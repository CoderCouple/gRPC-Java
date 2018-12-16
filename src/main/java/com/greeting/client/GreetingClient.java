package com.greeting.client;

//import com.proto.dummy.DummyServiceGrpc.*;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.proto.greet.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

//import static com.proto.dummy.DummyServiceGrpc.newBlockingStub;
//import static com.proto.dummy.DummyServiceGrpc.newFutureStub;

public class GreetingClient {


    private void run() throws InvalidProtocolBufferException {

        System.out.println("Creating the chanel");
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                //this method is used to remove the ALPN error related to security
                .usePlaintext()
                .build();

        //doUnaryServiceCall(channel);
        //doServerStreamingCall(channel);
        //doClientStreamingCall(channel);
        doBiDirectionalStreamingCall(channel);

        System.out.println("Closing the chanel");
        channel.shutdown();
    }

    private void doUnaryServiceCall(ManagedChannel channel) throws InvalidProtocolBufferException {
        //Synchronous client
        //DummyServiceBlockingStub syncClient =  newBlockingStub(channel);

        //Asynchronous client
        //DummyServiceFutureStub asyncClient =  newFutureStub(channel);


        //Creating stub
        GreetServiceGrpc.GreetServiceBlockingStub client = GreetServiceGrpc.newBlockingStub(channel);


        //Do Something here
        Greeting greeting = Greeting
                .newBuilder()
                .setFirstName("Sunil")
                .setLastName("Tiwari")
                .build();

        GreetRequest greetRequest = GreetRequest
                .newBuilder()
                .setGreeting(greeting)
                .build();


        GreetResponse greetResponse = client.greet(greetRequest);

        System.out.println(greetResponse.getResult());
        String jsonString = JsonFormat.printer().print(greetResponse);
        System.out.println(jsonString);

    }

    private void doServerStreamingCall(ManagedChannel channel) {

        //Creating stub
        GreetServiceGrpc.GreetServiceBlockingStub client = GreetServiceGrpc.newBlockingStub(channel);


        //Do Something here
        Greeting greeting = Greeting
                .newBuilder()
                .setFirstName("Sunil")
                .setLastName("Tiwari")
                .build();

        GreetManyTimesRequest greetManyTimesRequest = GreetManyTimesRequest
                .newBuilder()
                .setGreeting(greeting)
                .build();

        Iterator<GreetManyTimesResponse> it = client.greetManyTimes(greetManyTimesRequest);

        while (it.hasNext()) {
            System.out.println(it.next().getResult());
        }
    }


    private void doClientStreamingCall(ManagedChannel channel) {

        GreetServiceGrpc.GreetServiceStub asyncClient = GreetServiceGrpc.newStub(channel);
        CountDownLatch latch = new CountDownLatch(1);
        StreamObserver<LongGreetingRequest> requestObserver = asyncClient.longGreeting(new StreamObserver<LongGreetingResponse>() {
            @Override
            public void onNext(LongGreetingResponse value) {
                //We we get a response from the server
                System.out.println("Received a response from the server.");
                System.out.println(value.getResult());
            }

            @Override
            public void onError(Throwable t) {
                //we will get an error from the server

            }

            @Override
            public void onCompleted() {
                //the server is done sending the data
                System.out.println("Server is completed sending data.");
                latch.countDown();
            }
        });


        requestObserver.onNext(LongGreetingRequest
                .newBuilder()
                .setGreeting(Greeting
                        .newBuilder()
                        .setFirstName("Sunil")
                        .setLastName("Tiwari")
                        .build())
                .build() );


        requestObserver.onNext(LongGreetingRequest
                .newBuilder()
                .setGreeting(Greeting
                        .newBuilder()
                        .setFirstName("Sapana")
                        .setLastName("Tiwari")
                        .build())
                .build() );

        requestObserver.onNext(LongGreetingRequest
                .newBuilder()
                .setGreeting(Greeting
                        .newBuilder()
                        .setFirstName("Payal")
                        .setLastName("Tiwari")
                        .build())
                .build() );

        requestObserver.onNext(LongGreetingRequest
                .newBuilder()
                .setGreeting(Greeting
                        .newBuilder()
                        .setFirstName("Satish")
                        .setLastName("Tiwari")
                        .build())
                .build() );

        requestObserver.onCompleted();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private void doBiDirectionalStreamingCall(ManagedChannel channel) {
        GreetServiceGrpc.GreetServiceStub asyncClient = GreetServiceGrpc.newStub(channel);
        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<GreetingEveryoneRequest> requestStreamObserver = asyncClient.greetingEveryone(new StreamObserver<GreetingEveryoneResponse>() {
            @Override
            public void onNext(GreetingEveryoneResponse value) {
                //Server is sending the data
                System.out.println("Response from the server : "+value.getResult());
            }

            @Override
            public void onError(Throwable t) {
                //Server is sending the error

            }

            @Override
            public void onCompleted() {
                //server is done sending the response
                System.out.println("Server is done sending data.");
                latch.countDown();

            }
        });

        Arrays.asList("Sunil" , "Satish", "Payal", "Sapana", "Sadhana" ).forEach(
                name -> {
                    System.out.println("Request from client : "+name);
                    requestStreamObserver
                        .onNext(GreetingEveryoneRequest
                                .newBuilder()
                                .setGreeting(Greeting
                                        .newBuilder()
                                        .setFirstName(name)
                                        .build())
                                .build());
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        requestStreamObserver.onCompleted();

    }

    public static void main(String[] args) throws InvalidProtocolBufferException {

        System.out.println("Hi I am a gRPC client ...!!!");

        GreetingClient gc = new GreetingClient();
        gc.run();

    }
}
