package org.example;

import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class Server extends StudentServiceGrpc.StudentServiceImplBase {

    @Override
    public void getStudent(StudentRequest request,
                           io.grpc.stub.StreamObserver<StudentResponse> responseObserver) {
        // Implement your logic here
        StudentResponse studentResponse = StudentResponse.newBuilder()
                .setName("Amrutha")
                .setAge(20)
                .build();
        responseObserver.onNext(studentResponse);
        responseObserver.onCompleted();
    }
}
