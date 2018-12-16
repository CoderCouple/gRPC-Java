package com.echo.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.File;
import java.io.IOException;

public class EchoServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("GRPC Server ...!!!!");

        Server server = ServerBuilder
                .forPort(50051)
                .addService(new EchoServiceImpl())
                .useTransportSecurity(new File("ssl/server.crt"),new File("ssl/server.pem"))
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
