package com.pabloquiroga.essentials.books;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/books")
public class BookResource {
    private final BooksService service;

    public BookResource(BooksService service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public Response getAllBooks(){
        return Response.ok(service.getAll()).build();
    }

    @POST
    @Path("/create")
    @Transactional
    public Book createBook(Book newBook){
        service.create(newBook);
        return newBook;
    }
}
