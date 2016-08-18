package io.atom.autocomplete.java;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.examples.helloworld.GreeterGrpc;

public class Bootstrap {

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder
		.forPort(8080)
		.addService(new GreeterGrpc.GreeterImplBase() {
		})
		.build()
		.start();
		server.awaitTermination();
	}

}
