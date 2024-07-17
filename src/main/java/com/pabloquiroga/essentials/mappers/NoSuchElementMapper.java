package com.pabloquiroga.essentials.mappers;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.NoSuchElementException;

@Provider
public class NoSuchElementMapper implements ExceptionMapper<NoSuchElementException> {

    @Override
    public Response toResponse(NoSuchElementException ex) {
        var error = new NoSuchElementMessage(ex.getMessage(), null);
        return Response
                .status(404)
                .entity(error)
                .build();
    }

    public record NoSuchElementMessage(String message, String details){}
}
