package com.calculator.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.IOException;

public class CalculatorServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(50055)
                .addService(new CalculatorServiceImpl())
                .addService(ProtoReflectionService.newInstance())
                .build();

        server.start();
        System.out.println("Server Started ...!!!");

        Runtime.getRuntime().addShutdownHook(new Thread(()-> {
            System.out.println("Received Shutdown Request!!!");
            server.shutdown();
            System.out.println("Successfully stopped server!!!");
        }));

        server.awaitTermination();
    }

}
