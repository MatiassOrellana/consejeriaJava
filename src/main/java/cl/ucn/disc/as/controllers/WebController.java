package cl.ucn.disc.as.controllers;

import cl.ucn.disc.as.Services.PersonaGrpcServiceGrpcImplBase;
import cl.ucn.disc.as.Services.PersonaGrpcServiceImpl;
import cl.ucn.disc.as.model.Persona;

import java.util.Optional;

public class WebController {

    app.get("/api/personas/rut/{rut}", ctx => {

        String rut = ctx.pathParam("rut");
        Optional<Persona> oPersona = this.sistema.getPersona(rut);
        ctx.json(oPersona.orElseThrow(() => new NotFoundResponse("Persona no encontrada: " + rut)));

    });

    app.get("/api/grpc/personas/rut/{rut}", ctx => {

        String rut = ctx.pathParam("rut");

        //channel
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("127.0.0.1", 3337)
                .usePlaintext()
                .build();
        //stub
        PersonaGrpcServiceGrpc.PersonaGrpcServiceBlockingStub stub =
                PersonaGrpcServiceGrpc.newBlockingStub(channel);
        //call the grpc
        PersonaGrpcResponse response = stub.retrieve(PersonaGrpcRequest
                .newBuilder()
                .setRut("200408195")
                .build());

        PersonaGrpc personaGrpc = response.getPersona();

        Optional<Persona> oPersona = Optional.of(Persona.builder()
                        .rut(personaGrpc.getRut())
                        .nombre(personaGrpc.getNombre())
                        .apellidos(personaGrpc.getApellidos())
                        .email(personaGrpc.getEmail())
                        .build());

        ctx.json(oPersona.orElseThrow(() => new NotFoundResponse("no se encontro a la persona con ese rut: " + rut)));

}
