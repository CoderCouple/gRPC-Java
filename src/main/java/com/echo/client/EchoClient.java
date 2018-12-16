package com.echo.client;


import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.proto.echo.EchoMessage;
import com.proto.echo.EchoServiceGrpc;
import com.proto.greet.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;



public class EchoClient {


    private void run() throws InvalidProtocolBufferException {

        System.out.println("Creating the chanel");
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                //this method is used to remove the ALPN error related to security
                .usePlaintext(true)
                .build();

        doUnaryServiceCall(channel);


        System.out.println("Closing the chanel");
        channel.shutdown();
    }

    private void doUnaryServiceCall(ManagedChannel channel) throws InvalidProtocolBufferException {



        //Creating stub
        EchoServiceGrpc.EchoServiceBlockingStub client = EchoServiceGrpc.newBlockingStub(channel);


        //Do Something here
        EchoMessage req = EchoMessage.newBuilder().setValue("Sunil").build();


        EchoMessage res = client.echo(req);

        System.out.println(res.getValue());
        String jsonString = JsonFormat.printer().print(res);
        System.out.println(jsonString);

    }


    public static void main(String[] args) throws InvalidProtocolBufferException {

        System.out.println("Hi I am a gRPC client ...!!!");

        EchoClient gc = new EchoClient();
        gc.run();

    }
}
