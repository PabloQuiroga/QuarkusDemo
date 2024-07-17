package com.pabloquiroga.essentials.greetings;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Optional;

@Path("/greetings")
public class GreetingResource {

    private final GreetingService service;

    public GreetingResource(GreetingService service){
        this.service = service;
    }

    /*
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus";
    } */

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greetings(@QueryParam("name") String name) {
        return service.greeting(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/con-nombre")
    public String greetingsWithName(@QueryParam("name") String name){
        return Optional.ofNullable(name)
                .map( n ->
                        (n.isEmpty()) ? "Hello"  : "Hello "+ n
                )
                .orElse("No se ha compartido un parametro para nombre");
    }

}
