package com.pabloquiroga.essentials.users;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/users")
public class UserResource {
    private final UserService service;

    public UserResource(UserService service){
        this.service = service;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserDefault(){
        return service.getDefaultUser();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id")
    public User getUserById(@QueryParam("id") int id){
        return service.getUserById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public List<User> getUsersList(){
        return service.getAll();
    }

    @POST
    @Path("/create")
    public boolean create(User user){
        return service.createUser(user);
    }
}
