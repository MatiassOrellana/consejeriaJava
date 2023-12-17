package cl.ucn.disc.as.Services;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class PersonaGrpcServiceImpl extends PersonaGrpcServiceGrpc.PersonaGrpcServiceImplBase {

    @Override
    public void retrieve(PersonaGrpcRequest request, StreamObserver<PersonaGrpcResponse> responseObserver){

        log.debug("Retrieving PersonaGrpc with rut = {}.", request.getRut());

        PersonaGrpc personaGrpc = PersonaGrpc.newBuilder()
                .setRut("200408195")
                .setNombre("Matias")
                .setApellidos("Orellana Hormazabal")
                .setEmail("matias.orellana@alumnos.ucn.cl")
                .setTelefono("+56 9 49789257")
                .build();

        responseObserver.onNext(PersonaGrpcResponse.newBuilder().setPersona(personaGrpc).build());

        responseObserver.onCompleted();
    }




}
