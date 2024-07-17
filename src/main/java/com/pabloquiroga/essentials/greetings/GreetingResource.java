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

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String greetings(@QueryParam("name") String name) {
        return service.greeting(name);
    }

}
