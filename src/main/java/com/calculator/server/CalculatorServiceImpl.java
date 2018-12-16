package com.calculator.server;

import com.proto.calculator.*;
import io.grpc.stub.StreamObserver;

public class CalculatorServiceImpl extends CalculatorServiceGrpc.CalculatorServiceImplBase {

    @Override
    public void sumAPI(SumAPIRequest request, StreamObserver<SumAPIResponse> responseObserver) {
        //super.sumAPI(request, responseObserver);

        int result = request.getOp1()+request.getOp2();

        SumAPIResponse sumAPIResponse = SumAPIResponse.newBuilder().setRes(result).build();
        responseObserver.onNext(sumAPIResponse);
        responseObserver.onCompleted();

    }


    @Override
    public void primeNumberDecompositionAPI(PrimeNumberDecompositionAPIRequest request, StreamObserver<PrimeNumberDecompositionAPIResponse> responseObserver) {
        //super.primeNumberDecompositionAPI(request, responseObserver);

        long n= request.getOp1();
        int k=2;


        while(n>1){
            if(n%k==0){

                System.out.println(k);
                PrimeNumberDecompositionAPIResponse response = PrimeNumberDecompositionAPIResponse
                        .newBuilder()
                        .setResult(k)
                        .build();

                responseObserver.onNext(response);
                n=n/k;
            } else {
                k++;
            }
        }

        responseObserver.onCompleted();

    }

    @Override
    public StreamObserver<ComputeAverageAPIRequest> computeAverageAPI(StreamObserver<ComputeAverageAPIResponse> responseObserver) {
        //return super.computeAverageAPI(responseObserver);


        StreamObserver<ComputeAverageAPIRequest> requestStreamObserver = new StreamObserver<ComputeAverageAPIRequest>() {

            double result =0;
            double count=0;

            @Override
            public void onNext(ComputeAverageAPIRequest value) {
                //Client sends the data
                System.out.println("Client sent data : "+value.getOp1());
                result = (result*count + value.getOp1())/++count;
            }

            @Override
            public void onError(Throwable t) {
                //client sends the error

            }
            @Override
            public void onCompleted() {
                //Client is done sending the data
                responseObserver.onNext(ComputeAverageAPIResponse
                        .newBuilder()
                        .setResult(result)
                        .build());
                System.out.println("Client is done sending data");
                responseObserver.onCompleted();

            }
        };

        return requestStreamObserver;

    }


    @Override
    public StreamObserver<FindMaximumAPIRequest> findMaximumAPI(StreamObserver<FindMaximumAPIResponse> responseObserver) {
        //return super.findMaximumAPI(responseObserver);

        StreamObserver<FindMaximumAPIRequest> requestStreamObserver = new StreamObserver<FindMaximumAPIRequest>() {

            long max=Long.MIN_VALUE;
            @Override
            public void onNext(FindMaximumAPIRequest value) {

                long currVal=value.getOp1();
                if(currVal>max)
                    max=currVal;

                responseObserver.onNext(FindMaximumAPIResponse
                        .newBuilder()
                        .setResult(max)
                        .build());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {
                System.out.println("Client is done sending the data.");
                responseObserver.onCompleted();
            }
        };

        return requestStreamObserver;
    }
}
