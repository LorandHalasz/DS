package com.example.springdemo.medicationDispenser;

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
 * <pre>
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: proto.proto")
public final class GreeterGrpc {

  private GreeterGrpc() {}

  public static final String SERVICE_NAME = "Assignment3.Greeter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.springdemo.medicationDispenser.Request,
      com.example.springdemo.medicationDispenser.AllReplies> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = com.example.springdemo.medicationDispenser.Request.class,
      responseType = com.example.springdemo.medicationDispenser.AllReplies.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.springdemo.medicationDispenser.Request,
      com.example.springdemo.medicationDispenser.AllReplies> getSayHelloMethod() {
    io.grpc.MethodDescriptor<com.example.springdemo.medicationDispenser.Request, com.example.springdemo.medicationDispenser.AllReplies> getSayHelloMethod;
    if ((getSayHelloMethod = GreeterGrpc.getSayHelloMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getSayHelloMethod = GreeterGrpc.getSayHelloMethod) == null) {
          GreeterGrpc.getSayHelloMethod = getSayHelloMethod = 
              io.grpc.MethodDescriptor.<com.example.springdemo.medicationDispenser.Request, com.example.springdemo.medicationDispenser.AllReplies>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Assignment3.Greeter", "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.springdemo.medicationDispenser.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.springdemo.medicationDispenser.AllReplies.getDefaultInstance()))
                  .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("SayHello"))
                  .build();
          }
        }
     }
     return getSayHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.springdemo.medicationDispenser.AllReplies,
      com.example.springdemo.medicationDispenser.Request> getTransmitResponseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "transmitResponse",
      requestType = com.example.springdemo.medicationDispenser.AllReplies.class,
      responseType = com.example.springdemo.medicationDispenser.Request.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.springdemo.medicationDispenser.AllReplies,
      com.example.springdemo.medicationDispenser.Request> getTransmitResponseMethod() {
    io.grpc.MethodDescriptor<com.example.springdemo.medicationDispenser.AllReplies, com.example.springdemo.medicationDispenser.Request> getTransmitResponseMethod;
    if ((getTransmitResponseMethod = GreeterGrpc.getTransmitResponseMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getTransmitResponseMethod = GreeterGrpc.getTransmitResponseMethod) == null) {
          GreeterGrpc.getTransmitResponseMethod = getTransmitResponseMethod = 
              io.grpc.MethodDescriptor.<com.example.springdemo.medicationDispenser.AllReplies, com.example.springdemo.medicationDispenser.Request>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Assignment3.Greeter", "transmitResponse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.springdemo.medicationDispenser.AllReplies.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.springdemo.medicationDispenser.Request.getDefaultInstance()))
                  .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("transmitResponse"))
                  .build();
          }
        }
     }
     return getTransmitResponseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.springdemo.medicationDispenser.Reply,
      com.example.springdemo.medicationDispenser.Request> getTransmitPositiveResponseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "transmitPositiveResponse",
      requestType = com.example.springdemo.medicationDispenser.Reply.class,
      responseType = com.example.springdemo.medicationDispenser.Request.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.springdemo.medicationDispenser.Reply,
      com.example.springdemo.medicationDispenser.Request> getTransmitPositiveResponseMethod() {
    io.grpc.MethodDescriptor<com.example.springdemo.medicationDispenser.Reply, com.example.springdemo.medicationDispenser.Request> getTransmitPositiveResponseMethod;
    if ((getTransmitPositiveResponseMethod = GreeterGrpc.getTransmitPositiveResponseMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getTransmitPositiveResponseMethod = GreeterGrpc.getTransmitPositiveResponseMethod) == null) {
          GreeterGrpc.getTransmitPositiveResponseMethod = getTransmitPositiveResponseMethod = 
              io.grpc.MethodDescriptor.<com.example.springdemo.medicationDispenser.Reply, com.example.springdemo.medicationDispenser.Request>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Assignment3.Greeter", "transmitPositiveResponse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.springdemo.medicationDispenser.Reply.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.springdemo.medicationDispenser.Request.getDefaultInstance()))
                  .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("transmitPositiveResponse"))
                  .build();
          }
        }
     }
     return getTransmitPositiveResponseMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GreeterStub newStub(io.grpc.Channel channel) {
    return new GreeterStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GreeterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GreeterBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GreeterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GreeterFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class GreeterImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sayHello(com.example.springdemo.medicationDispenser.Request request,
        io.grpc.stub.StreamObserver<com.example.springdemo.medicationDispenser.AllReplies> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    /**
     */
    public void transmitResponse(com.example.springdemo.medicationDispenser.AllReplies request,
        io.grpc.stub.StreamObserver<com.example.springdemo.medicationDispenser.Request> responseObserver) {
      asyncUnimplementedUnaryCall(getTransmitResponseMethod(), responseObserver);
    }

    /**
     */
    public void transmitPositiveResponse(com.example.springdemo.medicationDispenser.Reply request,
        io.grpc.stub.StreamObserver<com.example.springdemo.medicationDispenser.Request> responseObserver) {
      asyncUnimplementedUnaryCall(getTransmitPositiveResponseMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.springdemo.medicationDispenser.Request,
                com.example.springdemo.medicationDispenser.AllReplies>(
                  this, METHODID_SAY_HELLO)))
          .addMethod(
            getTransmitResponseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.springdemo.medicationDispenser.AllReplies,
                com.example.springdemo.medicationDispenser.Request>(
                  this, METHODID_TRANSMIT_RESPONSE)))
          .addMethod(
            getTransmitPositiveResponseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.springdemo.medicationDispenser.Reply,
                com.example.springdemo.medicationDispenser.Request>(
                  this, METHODID_TRANSMIT_POSITIVE_RESPONSE)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class GreeterStub extends io.grpc.stub.AbstractStub<GreeterStub> {
    private GreeterStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreeterStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreeterStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sayHello(com.example.springdemo.medicationDispenser.Request request,
        io.grpc.stub.StreamObserver<com.example.springdemo.medicationDispenser.AllReplies> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void transmitResponse(com.example.springdemo.medicationDispenser.AllReplies request,
        io.grpc.stub.StreamObserver<com.example.springdemo.medicationDispenser.Request> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTransmitResponseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void transmitPositiveResponse(com.example.springdemo.medicationDispenser.Reply request,
        io.grpc.stub.StreamObserver<com.example.springdemo.medicationDispenser.Request> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTransmitPositiveResponseMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class GreeterBlockingStub extends io.grpc.stub.AbstractStub<GreeterBlockingStub> {
    private GreeterBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreeterBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreeterBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.example.springdemo.medicationDispenser.AllReplies sayHello(com.example.springdemo.medicationDispenser.Request request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.springdemo.medicationDispenser.Request transmitResponse(com.example.springdemo.medicationDispenser.AllReplies request) {
      return blockingUnaryCall(
          getChannel(), getTransmitResponseMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.springdemo.medicationDispenser.Request transmitPositiveResponse(com.example.springdemo.medicationDispenser.Reply request) {
      return blockingUnaryCall(
          getChannel(), getTransmitPositiveResponseMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class GreeterFutureStub extends io.grpc.stub.AbstractStub<GreeterFutureStub> {
    private GreeterFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GreeterFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GreeterFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.springdemo.medicationDispenser.AllReplies> sayHello(
        com.example.springdemo.medicationDispenser.Request request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.springdemo.medicationDispenser.Request> transmitResponse(
        com.example.springdemo.medicationDispenser.AllReplies request) {
      return futureUnaryCall(
          getChannel().newCall(getTransmitResponseMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.springdemo.medicationDispenser.Request> transmitPositiveResponse(
        com.example.springdemo.medicationDispenser.Reply request) {
      return futureUnaryCall(
          getChannel().newCall(getTransmitPositiveResponseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;
  private static final int METHODID_TRANSMIT_RESPONSE = 1;
  private static final int METHODID_TRANSMIT_POSITIVE_RESPONSE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GreeterImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GreeterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((com.example.springdemo.medicationDispenser.Request) request,
              (io.grpc.stub.StreamObserver<com.example.springdemo.medicationDispenser.AllReplies>) responseObserver);
          break;
        case METHODID_TRANSMIT_RESPONSE:
          serviceImpl.transmitResponse((com.example.springdemo.medicationDispenser.AllReplies) request,
              (io.grpc.stub.StreamObserver<com.example.springdemo.medicationDispenser.Request>) responseObserver);
          break;
        case METHODID_TRANSMIT_POSITIVE_RESPONSE:
          serviceImpl.transmitPositiveResponse((com.example.springdemo.medicationDispenser.Reply) request,
              (io.grpc.stub.StreamObserver<com.example.springdemo.medicationDispenser.Request>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GreeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GreeterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.springdemo.medicationDispenser.Proto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Greeter");
    }
  }

  private static final class GreeterFileDescriptorSupplier
      extends GreeterBaseDescriptorSupplier {
    GreeterFileDescriptorSupplier() {}
  }

  private static final class GreeterMethodDescriptorSupplier
      extends GreeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GreeterMethodDescriptorSupplier(String methodName) {
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
      synchronized (GreeterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GreeterFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .addMethod(getTransmitResponseMethod())
              .addMethod(getTransmitPositiveResponseMethod())
              .build();
        }
      }
    }
    return result;
  }
}
