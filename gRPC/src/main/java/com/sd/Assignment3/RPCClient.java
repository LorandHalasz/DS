/*
 * Copyright 2015 The gRPC Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sd.Assignment3;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RPCClient {
  private static final Logger logger = Logger.getLogger(RPCClient.class.getName());

  private final ManagedChannel channel;
  private final GreeterGrpc.GreeterBlockingStub blockingStub;

  /** Construct client connecting to RPC server at {@code host:port}. */
  public RPCClient(String host, int port) {
    this(ManagedChannelBuilder.forAddress(host, port)
        // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
        // needing certificates.
        .usePlaintext()
        .build());
  }

  /** Construct client for accessing RPC server using the existing channel. */
  RPCClient(ManagedChannel channel) {
    this.channel = channel;
    blockingStub = GreeterGrpc.newBlockingStub(channel);
  }

  public void shutdown() throws InterruptedException {
    channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
  }

  public AllReplies greet(String date) {
    Request request = Request.newBuilder().setDate(date).build();
    AllReplies responses;
    try {
        responses = blockingStub.sayHello(request);
        return responses;
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return null;
    }
  }

  public Request greetTrans(AllReplies allReplies){
      try {
          return blockingStub.transmitResponse(allReplies);
      } catch (StatusRuntimeException e) {
          logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
          return null;
      }
  }

    public Request greetPositiveTrans(Reply reply){
        try {
            return blockingStub.transmitPositiveResponse(reply);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return null;
        }
    }
}
