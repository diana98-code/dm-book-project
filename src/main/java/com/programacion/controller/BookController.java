package com.programacion.controller;

import com.programacion.entity.Book;
import com.programacion.services.BookService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/books")
public class BookController {

    @Inject
    private BookService bookService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book findAll(@PathParam("id") Integer id) {
        return bookService.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insert(Book book) {
        try {
            bookService.insert(book);
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo guardar el libro").build();
        }
        return Response
                .status(Response.Status.CREATED)
                .entity("Libro guardado con satisfactoriamente")
                .build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Integer id, Book book) {
        try {
            bookService.update(book, id);
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(String.format("No se pudo actualizar el libro: %s", id))
                    .build();
        }
        return Response
                .status(Response.Status.CREATED)
                .entity(String.format("El libro %s ha sido actualizado", id))
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Integer id) {
        try {
            bookService.delete(id);
        } catch (Exception ex) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(String.format("No se pudo eliminar el libro: %s", id))
                    .build();
        }
        return Response
                .status(Response.Status.CREATED)
                .entity(String.format("El libro %s ha sido eliminado", id))
                .build();
    }

}
