package com.pabloquiroga.essentials.greetings.resources;

import com.pabloquiroga.essentials.greetings.services.GreetingService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/greetings")
public class GreetingResource {

    private final GreetingService service;

    public GreetingResource(GreetingService service){
        this.service = service;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{name}")
    public String greetins(String name) {
        return service.greeting(name);
    }
}
