package com.dolmengi.grpc.service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class GreeterGrpcClient {

	private GreeterGrpc.GreeterBlockingStub greeterBlockingStub;

	public void test() {
		HelloRequest.Builder requestBuilder = HelloRequest.newBuilder();
		requestBuilder.setName("world");

		HelloRequest requestMessage = requestBuilder.build();

		HelloReply response = greeterBlockingStub.sayHello(requestMessage);
		System.out.println("===== gRPC Client getData Response =====");
		System.out.println(response);
		System.out.println("================================");
	}

	@PostConstruct
	private void initializeClient() {
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("127.0.0.1", 9090)
				.usePlaintext(true)
				.build();

		greeterBlockingStub = GreeterGrpc.newBlockingStub(channel);
	}

}
