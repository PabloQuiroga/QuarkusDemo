package com.pabloquiroga.essentials.users;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.NoSuchElementException;

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

    /**
     * Using DDBB
     */
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        var response = service.getAllUsers();

        if (!response.isEmpty()) {
            return Response.ok(response).build();
        } else {
            return Response.noContent().build();
        }
    }

    @GET
    @Path("/first")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFirst(){
        var response = service.getFirst()
                .orElseThrow(() ->
                        new NoSuchElementException("No hay datos"));

        return Response.ok(response).build();
    }

    @GET
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@QueryParam("id") Long id){
        var response = service.getById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("No hay datos que coincidan con la busqueda"));
        return Response.ok(response).build();
    }

    @POST
    @Transactional
    public Response saveUser(User user){
        service.create(user);
        return Response.ok(user).build();
    }
}
