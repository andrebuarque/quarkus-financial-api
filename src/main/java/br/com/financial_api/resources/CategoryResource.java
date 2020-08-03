package br.com.financial_api.resources;

import br.com.financial_api.dtos.CategoryDTO;
import br.com.financial_api.entities.Category;
import br.com.financial_api.services.CategoryService;
import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.annotations.Status;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResource {
    @Inject
    CategoryService service;

    @GET
    public Uni<List<Category>> listAll() {
        return service.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<Response> create(@Valid CategoryDTO dto) {
        return dto.toEntity().persist()
            .onItem().apply(item -> Response.status(Response.Status.CREATED))
            .onItem().apply(Response.ResponseBuilder::build);
    }
}