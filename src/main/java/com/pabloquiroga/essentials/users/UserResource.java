package com.pabloquiroga.essentials.users;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@Path("/users")
public class UserResource {
    private final UserService service;

    public UserResource(UserService service){
        this.service = service;
    }

    @GET
    public Response getMessageResponse(){
        return Response.ok(service.getClassMessage()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/default")
    public User getUserDefault(){
        return service.getDefaultUser();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id")
    public Response getUserById(@QueryParam("id") int id){
        Optional<User> opt = service.getUserById(id);
        if(opt.isPresent()){
            return Response.ok(opt.get()).build();
        } else {
            return Response.status(404).entity("No hay datos que coincidan con lo solicitado").build();
        }
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
