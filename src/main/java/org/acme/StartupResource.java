package org.acme;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/startup")
public class StartupResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Startup> listaTodasStartups() {
        return Startup.listAll();
    }

    @POST
    @Transactional
    public void criarStartup(StartupDTO dto){

        Startup s = new Startup();
        s.nome = dto.nome;
        s.funcionarios = dto.funcionarios;
        s.local = dto.local;
        
               
        s.persist();

    }

    @PUT
    @Path("{id}")
    @Transactional
    public void atualizarStartup(@PathParam("id") Long id, StartupDTO dto) {

        Optional<Startup> startupOp = Startup.findByIdOptional(id);

        if (startupOp.isPresent()) {
            Startup s = startupOp.get();
            s.nome = dto.nome;
            s.funcionarios = dto.funcionarios;
            s.local = dto.local;
                      
            s.persist();
        } else {
            throw new NotFoundException();
        }

    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void buscarTodosProdutos(@PathParam("id") Long id) {

        Optional<Pitch> pitchOp = Pitch.findByIdOptional(id);

        pitchOp.ifPresentOrElse(Pitch::delete, () -> {
            throw new NotFoundException();
        });

    }

}
