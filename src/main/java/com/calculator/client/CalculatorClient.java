package com.calculator.client;

import com.proto.calculator.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class CalculatorClient {


    public void run(){
        ManagedChannel chanel = ManagedChannelBuilder
                .forAddress("localhost",50055)
                .usePlaintext()
                .build();

        //callSumAPI(chanel);
        //callPrimeNumberDecomposition(chanel);
        //callComputeAverageAPI(chanel);
        callFindMaximumAPI(chanel);

        chanel.shutdown();
    }


    private void callSumAPI(ManagedChannel chanel){

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first Number : ");
        int num1=sc.nextInt();

        System.out.print("Enter Second Number : ");
        int num2=sc.nextInt();

        CalculatorServiceGrpc.CalculatorServiceBlockingStub client = CalculatorServiceGrpc.newBlockingStub(chanel);

        SumAPIRequest request = SumAPIRequest.newBuilder().setOp1(num1).setOp2(num2).build();
        SumAPIResponse response = client.sumAPI(request);

        System.out.println("Sum is : "+response.getRes());

    }

    private void callPrimeNumberDecomposition(ManagedChannel chanel){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number : ");
        long num1=sc.nextLong();

        CalculatorServiceGrpc.CalculatorServiceBlockingStub client = CalculatorServiceGrpc.newBlockingStub(chanel);
        PrimeNumberDecompositionAPIRequest request =PrimeNumberDecompositionAPIRequest.newBuilder().setOp1(num1).build();

        Iterator<PrimeNumberDecompositionAPIResponse> responseIterator = client.primeNumberDecompositionAPI(request);

        int i=1;
        while(responseIterator.hasNext()){
            System.out.println("Prime Factor "+i+" is : "+responseIterator.next().getResult());
            i++;
        }
    }


    private void callComputeAverageAPI(ManagedChannel chanel){

        CalculatorServiceGrpc.CalculatorServiceStub asyncClient = CalculatorServiceGrpc.newStub(chanel);
        CountDownLatch latch = new CountDownLatch(1);
        StreamObserver<ComputeAverageAPIRequest> requestStreamObserver = asyncClient.computeAverageAPI(new StreamObserver<ComputeAverageAPIResponse>() {
            @Override
            public void onNext(ComputeAverageAPIResponse value) {
                System.out.println("Server sent Response : "+ value.getResult());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("Server Done sending data.");
                latch.countDown();
            }
        });


        requestStreamObserver.onNext(ComputeAverageAPIRequest
                .newBuilder()
                .setOp1(1)
                .build());

        requestStreamObserver.onNext(ComputeAverageAPIRequest
                .newBuilder()
                .setOp1(2)
                .build());

        requestStreamObserver.onNext(ComputeAverageAPIRequest
                .newBuilder()
                .setOp1(3)
                .build());

        requestStreamObserver.onNext(ComputeAverageAPIRequest
                .newBuilder()
                .setOp1(4)
                .build());

        requestStreamObserver.onNext(ComputeAverageAPIRequest
                .newBuilder()
                .setOp1(5)
                .build());

        requestStreamObserver.onCompleted();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void callFindMaximumAPI(ManagedChannel chanel){
        CalculatorServiceGrpc.CalculatorServiceStub asyncClient = CalculatorServiceGrpc.newStub(chanel);
        CountDownLatch latch = new CountDownLatch(1);
        StreamObserver<FindMaximumAPIRequest> requestStreamObserver = asyncClient.findMaximumAPI(new StreamObserver<FindMaximumAPIResponse>() {
            @Override
            public void onNext(FindMaximumAPIResponse value) {
                System.out.println("Server sent response : "+value.getResult());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("Server is done sending the response.");
                latch.countDown();
            }
        });


        Arrays.asList(1,-2,5,4,100,-1,-2,-3,-4,-5,-6,-7,-8,-8,-10,500).forEach(
                number -> {
                    System.out.println("client sent request : "+number);
                    requestStreamObserver.onNext(FindMaximumAPIRequest
                            .newBuilder()
                            .setOp1(number)
                            .build());

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        requestStreamObserver.onCompleted();;

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String args []){
        CalculatorClient cc = new CalculatorClient();
        cc.run();
    }
}
