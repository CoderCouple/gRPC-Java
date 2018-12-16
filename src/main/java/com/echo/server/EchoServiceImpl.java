package com.echo.server;

import com.proto.echo.EchoMessage;
import com.proto.echo.EchoServiceGrpc;
import com.proto.greet.*;
import io.grpc.stub.StreamObserver;

public class EchoServiceImpl extends EchoServiceGrpc.EchoServiceImplBase{
    @Override
    public void echo(EchoMessage request, StreamObserver<EchoMessage> responseObserver) {
        //super.echo(request, responseObserver);
        System.out.println("Echo Server Impl Base");

        System.out.println("Servicing the request");
        //Extract information from the request object
        String val =request.getValue();

        //Process the request
        String result = "Echo "+val ;

        //create the response messsage
        EchoMessage response = EchoMessage.newBuilder()
                .setValue(result)
                .build();

        //send the response to the client
        responseObserver.onNext(response);

        //Complete the rpc call
        responseObserver.onCompleted();
    }
}
