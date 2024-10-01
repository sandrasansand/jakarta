package org.asaez.webapp.jaxws.controllers;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.asaez.webapp.jaxws.models.Curso;
import org.asaez.webapp.jaxws.services.CursoService;
import java.util.List;
import java.util.Optional;

@RequestScoped
@Path("/cursos")
//podríamos hacerlo con objs (MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_JSON)
public class CursoRestController {

    @Inject
    private CursoService service;

    @GET
    public List<Curso> listar() {
        return service.listar();
    }

    @GET
    @Path("/{id}")
    public Response porId(@PathParam("id") Long id) {
        Optional<Curso> cursoOptional = service.porId(id);
        if (cursoOptional.isPresent()) {
            return Response.ok(cursoOptional.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Curso curso) {
        try {
            Curso nuevoCurso = service.guardar(curso);
            return Response.ok(nuevoCurso).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editar(@PathParam("id") Long id, Curso curso) {
        Optional<Curso> cursoOptional = service.porId(id);
        if (cursoOptional.isPresent()) {

            Curso nuevoCurso = cursoOptional.get();
            nuevoCurso.setNombre(curso.getNombre());
            nuevoCurso.setDescripcion(curso.getDescripcion());
            nuevoCurso.setDuracion(curso.getDuracion());
            nuevoCurso.setInstructor(curso.getInstructor());

            try {
                service.guardar(nuevoCurso);
                return Response.ok(nuevoCurso).build();
            } catch (Exception e) {
                e.printStackTrace();
                return Response.serverError().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("/{id}")
    public Response eliminar(@PathParam("id") Long id) {
        Optional<Curso> cursoOptional = service.porId(id);
        if(cursoOptional.isPresent()){
            try {
                service.eliminar(cursoOptional.get().getId());
                return Response.noContent().build();
            } catch (Exception e) {
                e.printStackTrace();
                return Response.serverError().build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}

