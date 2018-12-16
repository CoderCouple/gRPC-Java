package com.proto.calculator;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.1)",
    comments = "Source: calculator/calculator.proto")
public final class CalculatorServiceGrpc {

  private CalculatorServiceGrpc() {}

  public static final String SERVICE_NAME = "calculator.CalculatorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.calculator.SumAPIRequest,
      com.proto.calculator.SumAPIResponse> getSumAPIMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SumAPI",
      requestType = com.proto.calculator.SumAPIRequest.class,
      responseType = com.proto.calculator.SumAPIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.calculator.SumAPIRequest,
      com.proto.calculator.SumAPIResponse> getSumAPIMethod() {
    io.grpc.MethodDescriptor<com.proto.calculator.SumAPIRequest, com.proto.calculator.SumAPIResponse> getSumAPIMethod;
    if ((getSumAPIMethod = CalculatorServiceGrpc.getSumAPIMethod) == null) {
      synchronized (CalculatorServiceGrpc.class) {
        if ((getSumAPIMethod = CalculatorServiceGrpc.getSumAPIMethod) == null) {
          CalculatorServiceGrpc.getSumAPIMethod = getSumAPIMethod = 
              io.grpc.MethodDescriptor.<com.proto.calculator.SumAPIRequest, com.proto.calculator.SumAPIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "calculator.CalculatorService", "SumAPI"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculator.SumAPIRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculator.SumAPIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CalculatorServiceMethodDescriptorSupplier("SumAPI"))
                  .build();
          }
        }
     }
     return getSumAPIMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.calculator.PrimeNumberDecompositionAPIRequest,
      com.proto.calculator.PrimeNumberDecompositionAPIResponse> getPrimeNumberDecompositionAPIMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PrimeNumberDecompositionAPI",
      requestType = com.proto.calculator.PrimeNumberDecompositionAPIRequest.class,
      responseType = com.proto.calculator.PrimeNumberDecompositionAPIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.calculator.PrimeNumberDecompositionAPIRequest,
      com.proto.calculator.PrimeNumberDecompositionAPIResponse> getPrimeNumberDecompositionAPIMethod() {
    io.grpc.MethodDescriptor<com.proto.calculator.PrimeNumberDecompositionAPIRequest, com.proto.calculator.PrimeNumberDecompositionAPIResponse> getPrimeNumberDecompositionAPIMethod;
    if ((getPrimeNumberDecompositionAPIMethod = CalculatorServiceGrpc.getPrimeNumberDecompositionAPIMethod) == null) {
      synchronized (CalculatorServiceGrpc.class) {
        if ((getPrimeNumberDecompositionAPIMethod = CalculatorServiceGrpc.getPrimeNumberDecompositionAPIMethod) == null) {
          CalculatorServiceGrpc.getPrimeNumberDecompositionAPIMethod = getPrimeNumberDecompositionAPIMethod = 
              io.grpc.MethodDescriptor.<com.proto.calculator.PrimeNumberDecompositionAPIRequest, com.proto.calculator.PrimeNumberDecompositionAPIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "calculator.CalculatorService", "PrimeNumberDecompositionAPI"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculator.PrimeNumberDecompositionAPIRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculator.PrimeNumberDecompositionAPIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CalculatorServiceMethodDescriptorSupplier("PrimeNumberDecompositionAPI"))
                  .build();
          }
        }
     }
     return getPrimeNumberDecompositionAPIMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.calculator.ComputeAverageAPIRequest,
      com.proto.calculator.ComputeAverageAPIResponse> getComputeAverageAPIMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ComputeAverageAPI",
      requestType = com.proto.calculator.ComputeAverageAPIRequest.class,
      responseType = com.proto.calculator.ComputeAverageAPIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.calculator.ComputeAverageAPIRequest,
      com.proto.calculator.ComputeAverageAPIResponse> getComputeAverageAPIMethod() {
    io.grpc.MethodDescriptor<com.proto.calculator.ComputeAverageAPIRequest, com.proto.calculator.ComputeAverageAPIResponse> getComputeAverageAPIMethod;
    if ((getComputeAverageAPIMethod = CalculatorServiceGrpc.getComputeAverageAPIMethod) == null) {
      synchronized (CalculatorServiceGrpc.class) {
        if ((getComputeAverageAPIMethod = CalculatorServiceGrpc.getComputeAverageAPIMethod) == null) {
          CalculatorServiceGrpc.getComputeAverageAPIMethod = getComputeAverageAPIMethod = 
              io.grpc.MethodDescriptor.<com.proto.calculator.ComputeAverageAPIRequest, com.proto.calculator.ComputeAverageAPIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "calculator.CalculatorService", "ComputeAverageAPI"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculator.ComputeAverageAPIRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculator.ComputeAverageAPIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CalculatorServiceMethodDescriptorSupplier("ComputeAverageAPI"))
                  .build();
          }
        }
     }
     return getComputeAverageAPIMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.calculator.FindMaximumAPIRequest,
      com.proto.calculator.FindMaximumAPIResponse> getFindMaximumAPIMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindMaximumAPI",
      requestType = com.proto.calculator.FindMaximumAPIRequest.class,
      responseType = com.proto.calculator.FindMaximumAPIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.calculator.FindMaximumAPIRequest,
      com.proto.calculator.FindMaximumAPIResponse> getFindMaximumAPIMethod() {
    io.grpc.MethodDescriptor<com.proto.calculator.FindMaximumAPIRequest, com.proto.calculator.FindMaximumAPIResponse> getFindMaximumAPIMethod;
    if ((getFindMaximumAPIMethod = CalculatorServiceGrpc.getFindMaximumAPIMethod) == null) {
      synchronized (CalculatorServiceGrpc.class) {
        if ((getFindMaximumAPIMethod = CalculatorServiceGrpc.getFindMaximumAPIMethod) == null) {
          CalculatorServiceGrpc.getFindMaximumAPIMethod = getFindMaximumAPIMethod = 
              io.grpc.MethodDescriptor.<com.proto.calculator.FindMaximumAPIRequest, com.proto.calculator.FindMaximumAPIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "calculator.CalculatorService", "FindMaximumAPI"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculator.FindMaximumAPIRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.calculator.FindMaximumAPIResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CalculatorServiceMethodDescriptorSupplier("FindMaximumAPI"))
                  .build();
          }
        }
     }
     return getFindMaximumAPIMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CalculatorServiceStub newStub(io.grpc.Channel channel) {
    return new CalculatorServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CalculatorServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CalculatorServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CalculatorServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CalculatorServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CalculatorServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *UNARY API
     * </pre>
     */
    public void sumAPI(com.proto.calculator.SumAPIRequest request,
        io.grpc.stub.StreamObserver<com.proto.calculator.SumAPIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSumAPIMethod(), responseObserver);
    }

    /**
     * <pre>
     *SERVER STREAMING API
     * </pre>
     */
    public void primeNumberDecompositionAPI(com.proto.calculator.PrimeNumberDecompositionAPIRequest request,
        io.grpc.stub.StreamObserver<com.proto.calculator.PrimeNumberDecompositionAPIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPrimeNumberDecompositionAPIMethod(), responseObserver);
    }

    /**
     * <pre>
     *CLIENT STREAMING API
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.proto.calculator.ComputeAverageAPIRequest> computeAverageAPI(
        io.grpc.stub.StreamObserver<com.proto.calculator.ComputeAverageAPIResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getComputeAverageAPIMethod(), responseObserver);
    }

    /**
     * <pre>
     *BIDIRECTIONAL STREAMING API
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.proto.calculator.FindMaximumAPIRequest> findMaximumAPI(
        io.grpc.stub.StreamObserver<com.proto.calculator.FindMaximumAPIResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getFindMaximumAPIMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSumAPIMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.calculator.SumAPIRequest,
                com.proto.calculator.SumAPIResponse>(
                  this, METHODID_SUM_API)))
          .addMethod(
            getPrimeNumberDecompositionAPIMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.proto.calculator.PrimeNumberDecompositionAPIRequest,
                com.proto.calculator.PrimeNumberDecompositionAPIResponse>(
                  this, METHODID_PRIME_NUMBER_DECOMPOSITION_API)))
          .addMethod(
            getComputeAverageAPIMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.proto.calculator.ComputeAverageAPIRequest,
                com.proto.calculator.ComputeAverageAPIResponse>(
                  this, METHODID_COMPUTE_AVERAGE_API)))
          .addMethod(
            getFindMaximumAPIMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.proto.calculator.FindMaximumAPIRequest,
                com.proto.calculator.FindMaximumAPIResponse>(
                  this, METHODID_FIND_MAXIMUM_API)))
          .build();
    }
  }

  /**
   */
  public static final class CalculatorServiceStub extends io.grpc.stub.AbstractStub<CalculatorServiceStub> {
    private CalculatorServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculatorServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculatorServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *UNARY API
     * </pre>
     */
    public void sumAPI(com.proto.calculator.SumAPIRequest request,
        io.grpc.stub.StreamObserver<com.proto.calculator.SumAPIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSumAPIMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *SERVER STREAMING API
     * </pre>
     */
    public void primeNumberDecompositionAPI(com.proto.calculator.PrimeNumberDecompositionAPIRequest request,
        io.grpc.stub.StreamObserver<com.proto.calculator.PrimeNumberDecompositionAPIResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getPrimeNumberDecompositionAPIMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *CLIENT STREAMING API
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.proto.calculator.ComputeAverageAPIRequest> computeAverageAPI(
        io.grpc.stub.StreamObserver<com.proto.calculator.ComputeAverageAPIResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getComputeAverageAPIMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *BIDIRECTIONAL STREAMING API
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.proto.calculator.FindMaximumAPIRequest> findMaximumAPI(
        io.grpc.stub.StreamObserver<com.proto.calculator.FindMaximumAPIResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getFindMaximumAPIMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class CalculatorServiceBlockingStub extends io.grpc.stub.AbstractStub<CalculatorServiceBlockingStub> {
    private CalculatorServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculatorServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculatorServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *UNARY API
     * </pre>
     */
    public com.proto.calculator.SumAPIResponse sumAPI(com.proto.calculator.SumAPIRequest request) {
      return blockingUnaryCall(
          getChannel(), getSumAPIMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *SERVER STREAMING API
     * </pre>
     */
    public java.util.Iterator<com.proto.calculator.PrimeNumberDecompositionAPIResponse> primeNumberDecompositionAPI(
        com.proto.calculator.PrimeNumberDecompositionAPIRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getPrimeNumberDecompositionAPIMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CalculatorServiceFutureStub extends io.grpc.stub.AbstractStub<CalculatorServiceFutureStub> {
    private CalculatorServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalculatorServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalculatorServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalculatorServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *UNARY API
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.calculator.SumAPIResponse> sumAPI(
        com.proto.calculator.SumAPIRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSumAPIMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUM_API = 0;
  private static final int METHODID_PRIME_NUMBER_DECOMPOSITION_API = 1;
  private static final int METHODID_COMPUTE_AVERAGE_API = 2;
  private static final int METHODID_FIND_MAXIMUM_API = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CalculatorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CalculatorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUM_API:
          serviceImpl.sumAPI((com.proto.calculator.SumAPIRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.calculator.SumAPIResponse>) responseObserver);
          break;
        case METHODID_PRIME_NUMBER_DECOMPOSITION_API:
          serviceImpl.primeNumberDecompositionAPI((com.proto.calculator.PrimeNumberDecompositionAPIRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.calculator.PrimeNumberDecompositionAPIResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COMPUTE_AVERAGE_API:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.computeAverageAPI(
              (io.grpc.stub.StreamObserver<com.proto.calculator.ComputeAverageAPIResponse>) responseObserver);
        case METHODID_FIND_MAXIMUM_API:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.findMaximumAPI(
              (io.grpc.stub.StreamObserver<com.proto.calculator.FindMaximumAPIResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CalculatorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CalculatorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.calculator.Calculator.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CalculatorService");
    }
  }

  private static final class CalculatorServiceFileDescriptorSupplier
      extends CalculatorServiceBaseDescriptorSupplier {
    CalculatorServiceFileDescriptorSupplier() {}
  }

  private static final class CalculatorServiceMethodDescriptorSupplier
      extends CalculatorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CalculatorServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CalculatorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CalculatorServiceFileDescriptorSupplier())
              .addMethod(getSumAPIMethod())
              .addMethod(getPrimeNumberDecompositionAPIMethod())
              .addMethod(getComputeAverageAPIMethod())
              .addMethod(getFindMaximumAPIMethod())
              .build();
        }
      }
    }
    return result;
  }
}
