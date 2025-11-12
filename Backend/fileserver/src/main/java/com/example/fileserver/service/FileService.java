package com.example.fileserver.service;

import org.springframework.core.io.buffer.DataBuffer;
import reactor.core.publisher.Flux;

public interface FileService {
    Flux<DataBuffer> getFileAsStream(String filename);
}
