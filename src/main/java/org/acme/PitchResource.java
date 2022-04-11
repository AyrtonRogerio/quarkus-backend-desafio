package org.acme;

import java.util.ArrayList;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Path("/pitch")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PitchResource {

    @GET
    
    public List<Pitch> bucarPitch() {
        return Pitch.listAll();
    }

    @POST
    @Transactional
    public Pitch criarPitch(Pitch p){

        //Pitch p = new Pitch();
      //  p.textoPitch = dto.textoPitch;
      //  p.serie_investimento = dto.serie_investimento;

        p.persist();
        
        return p;
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void atualizarPitch(@PathParam("id") Long id, PitchDTO dto) {

        Optional<Pitch> pitchOp = Pitch.findByIdOptional(id);

        if (pitchOp.isPresent()) {
            Pitch pitch = pitchOp.get();
            pitch.textoPitch = dto.textoPitch;           
            pitch.serie_investimento = dto.serie_investimento;
            pitch.persist();
        } else {
            throw new NotFoundException();
        }

    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void deletarPitch(@PathParam("id") Long id) {

        Optional<Pitch> pitchOp = Pitch.findByIdOptional(id);

        pitchOp.ifPresentOrElse(Pitch::delete, () -> {
            throw new NotFoundException();
        });

    }


    @GET
    @Path("buscar")
    @Consumes(MediaType.APPLICATION_JSON)
    public ArrayList<Pitch> buscarPorLocalQtdFuncionariosInvestimento(@QueryParam("serie_investimento") String investimento, @QueryParam("local") String local, 
     @QueryParam("funcionarios") int func) {
      
      ArrayList<Pitch> pitchs = new ArrayList<Pitch>();
      List<Pitch> pitchsInvestimentos = Pitch.find("serie_investimento like ?1", investimento).list();
      
      List<Startup> startups=Startup.find("local like ?1 and funcionarios <= ?2 ", local, func).list();
      
      for (Startup startup : startups) {
        for(Pitch p:pitchsInvestimentos){
          if(startup==p.startup){
            pitchs.add(p);
          }
        }
      }
  
      return pitchs;
    } 

}