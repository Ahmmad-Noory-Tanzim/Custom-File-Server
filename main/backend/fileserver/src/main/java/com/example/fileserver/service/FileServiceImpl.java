package com.example.fileserver.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService{

    private static final Path FILE_DIRECTORY = Paths.get("/app/files"); //"src/main/resources/iso-files" for local dev

    @Override
    public Flux<DataBuffer> getFileAsStream(String filename){
        Path filePath = FILE_DIRECTORY.resolve(filename);
        System.out.println("Requested filename: " + filename);
        System.out.println("Full file path: " + filePath.toAbsolutePath());
        System.out.println("File exists? " + Files.exists(filePath));
        FileSystemResource resource = new FileSystemResource(filePath);
        return DataBufferUtils.read(resource, new DefaultDataBufferFactory(), 8 * 1024 * 1024);
    }

}
