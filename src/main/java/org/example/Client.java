package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
    public static void main(String[] args) {
        // Create a channel to connect to the server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .usePlaintext() // Use plaintext communication
                .build();

        // Create a stub for the service
        StudentServiceGrpc.StudentServiceBlockingStub stub = StudentServiceGrpc.newBlockingStub(channel);

        // Create a request
        StudentRequest request = StudentRequest.newBuilder()
                .setId(1) // Set the ID of the student you want to retrieve
                .build();

        // Call the service method and get the response
        StudentResponse response = stub.getStudent(request);

        // Print the response
        System.out.println("Student Name: " + response.getName());
        System.out.println("Student Age: " + response.getAge());

        // Shutdown the channel
        channel.shutdown();
    }
}
