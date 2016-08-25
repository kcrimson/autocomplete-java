package io.atom.autocomplete.java;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.examples.helloworld.GreeterGrpc;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.stub.StreamObserver;

public class Bootstrap {

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder
		.forPort(8080)
		.addService(new GreeterGrpc.GreeterImplBase() {

            @Override
            public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
                responseObserver.onNext(HelloReply.newBuilder().setMessage("Hello "+request.getName()).build());
                responseObserver.onCompleted();
            }
			
		})
		.build()
		.start();
		server.awaitTermination();
	}

}
