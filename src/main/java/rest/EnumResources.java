package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import rest.dto.EnumDictionaryDto;

@Path("/enumDictionary")
@Stateless
public class EnumResources {

	Mapper mapper = new DozerBeanMapper();
	
    @PersistenceContext
    EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
    	List<EnumDictionaryDto> result = new ArrayList<EnumDictionaryDto>();
    	for(EnumDictionaryDto ed: em.createNamedQuery("enumDictionary.all",EnumDictionaryDto.class).getResultList()){
    		result.add(mapper.map(ed, EnumDictionaryDto.class));
    	}
    	return Response.ok(new GenericEntity<List<EnumDictionaryDto>>(result){}).build();
    }
    
    @GET
    @Path("/{enumerationName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("enumerationName") String enumerationName){
        EnumDictionaryDto result = em.createNamedQuery("enumDictionary.enumerationName",EnumDictionaryDto.class)
        		.setParameter("enumerationName", enumerationName).getSingleResult();
        if(result == null)
        {
         return Response.status(404).build();
        }
        else
        {
         return Response.ok(result).build();
        }
        
        		
        		
    }
    
}
