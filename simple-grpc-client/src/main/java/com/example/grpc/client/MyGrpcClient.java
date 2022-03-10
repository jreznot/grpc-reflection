package com.example.grpc.client;

import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
import com.example.grpc.Sentiment;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MyGrpcClient {
  public static void main(String[] args) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
        .usePlaintext()
        .build();

    GreetingServiceGrpc.GreetingServiceBlockingStub stub =
        GreetingServiceGrpc.newBlockingStub(channel);

    HelloResponse helloResponse = stub.greeting(
        HelloRequest.newBuilder()
            .setName("Ray")
            .setAge(18)
            .setSentiment(Sentiment.HAPPY)
            .build());

    System.out.println(helloResponse);

    channel.shutdown();
  }
}
