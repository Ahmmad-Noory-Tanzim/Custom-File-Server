package com.example.fileserver.router;

import com.example.fileserver.handler.FileHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class FIleRouter {
    @Bean
    public RouterFunction<ServerResponse> fileRoutes(FileHandler fileHandler){
        return RouterFunctions
                .route(GET("api/files/{filename}"), fileHandler::downloadFile);
    }
}
