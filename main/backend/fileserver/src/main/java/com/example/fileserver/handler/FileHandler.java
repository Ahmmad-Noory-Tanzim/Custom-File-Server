package com.example.fileserver.handler;

import com.example.fileserver.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Component
public class FileHandler {

    @Autowired
    private FileService fileService;

    public Mono<ServerResponse> downloadFile(ServerRequest serverRequest){
        String filename = serverRequest.pathVariable("filename");
        Flux<DataBuffer> fileStream = fileService.getFileAsStream(filename);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header("Content-Disposition", "attachment; filename=\"" + filename + "\"")
                .body(fileStream, DataBuffer.class);
    }
}
