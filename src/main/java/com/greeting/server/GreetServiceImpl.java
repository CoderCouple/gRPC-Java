package com.greeting.server;

import com.proto.greet.*;
import io.grpc.stub.StreamObserver;
import io.grpc.stub.StreamObservers;

public class GreetServiceImpl extends GreetServiceGrpc.GreetServiceImplBase{
    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        //super.greet(request, responseObserver);

        System.out.println("Servicing the request");
        //Extract information from the request object
        Greeting greeting =request.getGreeting();

        //Process the request
        String result = "Hello "+greeting.getFirstName()+" "+greeting.getLastName()+"...!!!!";

        //create the response messsage
        GreetResponse response = GreetResponse.newBuilder()
                .setResult(result)
                .build();

        //send the response to the client
        responseObserver.onNext(response);

        //Complete the rpc call
        responseObserver.onCompleted();

    }

    @Override
    public void greetManyTimes(GreetManyTimesRequest request, StreamObserver<GreetManyTimesResponse> responseObserver) {
        //super.greetManyTimes(request, responseObserver);

        String firstName= request.getGreeting().getFirstName();
        String lastName= request.getGreeting().getLastName();

        try {
            for (int i = 1; i <= 10; i++) {
                String result = "Hello " + firstName + " " + lastName + "...!!!! This is response No: " + i;
                GreetManyTimesResponse greetManyTimesResponse = GreetManyTimesResponse
                        .newBuilder()
                        .setResult(result)
                        .build();

                responseObserver.onNext(greetManyTimesResponse);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            responseObserver.onCompleted();
        }

    }

    @Override
    public StreamObserver<LongGreetingRequest> longGreeting(StreamObserver<LongGreetingResponse> responseObserver) {
        //return super.longGreeting(responseObserver);

        StreamObserver<LongGreetingRequest> streamForClient = new StreamObserver<LongGreetingRequest>() {

            String result="";

            @Override
            public void onNext(LongGreetingRequest value) {
                //Client sends a message
                result +="Hello "+value.getGreeting().getFirstName()+" !";
            }

            @Override
            public void onError(Throwable t) {
                //Client sends an error

            }

            @Override
            public void onCompleted() {
                //Client is done sending the data
                responseObserver.onNext(LongGreetingResponse
                        .newBuilder()
                        .setResult(result)
                        .build());

                responseObserver.onCompleted();

                //this is where we want to return the result.

            }
        };

       return streamForClient;
    }


    @Override
    public StreamObserver<GreetingEveryoneRequest> greetingEveryone(StreamObserver<GreetingEveryoneResponse> responseObserver) {
        //return super.greetingEveryone(responseObserver);

        StreamObserver<GreetingEveryoneRequest> requestStreamObserver = new StreamObserver<GreetingEveryoneRequest>() {
            @Override
            public void onNext(GreetingEveryoneRequest value) {
                //Client sent the data
                //System.out.println("Request from client");
                String result="Hello "+value.getGreeting().getFirstName()+"!";
                responseObserver.onNext(GreetingEveryoneResponse
                        .newBuilder()
                        .setResult(result)
                        .build());
            }

            @Override
            public void onError(Throwable t) {
                //Client sent the error

            }

            @Override
            public void onCompleted() {
                //Client is done sending the data
                System.out.println("Client is done sending the data.");
                responseObserver.onCompleted();
            }
        };

        return requestStreamObserver;
    }
}
