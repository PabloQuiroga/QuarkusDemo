package com.pabloquiroga.essentials.users;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.NoSuchElementException;

@Path("/users-demo")
public class UsersResourcesBasics {
    private final UserService service;

    public UsersResourcesBasics(UserService service){
        this.service = service;
    }

    @GET
    public Response getMessageResponse(){
        return Response.ok(service.getClassMessage()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/default")
    public Response getUserDefault(){
        var response = service.getDefaultUser()
                .orElseThrow(() ->
                        new NoSuchElementException("No hay datos que coincidan con lo solicitado"));
        return Response.ok(response).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id")
    public Response getUserById(@QueryParam("id") int id){
        var response = service.getUserById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("No hay datos que coincidan con lo solicitado"));

        return Response.ok(response).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public List<User> getUsersList(){
        return service.getAll();
    }

    @POST
    @Path("create")
    public boolean create(User user){
        return service.createUser(user);
    }
}
