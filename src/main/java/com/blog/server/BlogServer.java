package com.blog.server;

import com.echo.server.EchoServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.IOException;

public class BlogServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("GRPC Server ...!!!!");

        Server server = ServerBuilder
                .forPort(50055)
                .addService(new BlogServiceImpl())
                .addService(ProtoReflectionService.newInstance())
                .build();


        server.start();


        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received Shutdown Request!!!");
            server.shutdown();
            System.out.println("Successfully stopped server!!!");
        }));

        server.awaitTermination();

    }
}
