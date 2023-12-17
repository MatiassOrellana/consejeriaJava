package cl.ucn.disc.as.controllers;

import cl.ucn.disc.as.Services.SystemImpl;
import cl.ucn.disc.as.model.Persona;
import cl.ucn.disc.as.model.exceptions.IllegalDomainException;
import io.ebean.DB;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.Optional;

public final class WebController implements RoutesConfigurator {

    private final SystemImpl sistema;


    public WebController() {
        this.sistema = new SystemImpl(DB.getDefault());
    }

    @Override
    public void configure(final Javalin app){

        app.get("/api/personas", ctx -> {

            ctx.json(this.sistema.getPersonas());

        });

        app.get("/api/grpc/personas/rut/{rut}", ctx -> {

            String rut = ctx.pathParam("rut");

            //channel
            ManagedChannel channel = ManagedChannelBuilder
                    .forAddress("localhost", 3337)
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

            Optional<Persona> oPersona = null;
            try {
                oPersona = Optional.of(Persona.builder()
                        .rut(personaGrpc.getRut())
                        .nombre(personaGrpc.getNombre())
                        .apellidos(personaGrpc.getApellidos())
                        .email(personaGrpc.getEmail())
                        .build());
            } catch (IllegalDomainException e) {
                throw new RuntimeException(e);
            }

            ctx.json(oPersona.orElseThrow(() -> new NotFoundResponse("no se encontro a la persona con ese rut: " + rut)));

        });

    }

}