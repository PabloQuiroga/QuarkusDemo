package com.pabloquiroga.essentials.users;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.NoSuchElementException;

@Path("/users")
public class UserResource {
    private final UserService service;

    public UserResource(UserService service){
        this.service = service;
    }

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

    @DELETE
    public Response deleteUser(@QueryParam("id") Long id){
        if (service.delete(id)){
            return Response.ok("Registro eliminado satisfactoriamente").build();
        } else {
            return Response.status(404).entity("Registro no encontrado").build();
        }
    }

    @PUT
    public Response updateUser(@QueryParam("id") String id, User user){
        if (service.update(id, user)) {
            return Response.ok("Registro actualizado correctamente").build();
        } else {
            return Response.status(404).entity("Registro no encontrado").build();
        }
    }

    @GET
    @Path("/adults")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdults(){
        var response = service.getAdultUsers();

        if (!response.isEmpty()) {
            return Response.ok(response).build();
        } else {
            return Response.noContent().build();
        }
    }
}
