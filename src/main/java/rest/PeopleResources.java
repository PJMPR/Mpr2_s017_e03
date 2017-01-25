package rest;

import domain.model.Person;
import domain.model.Wallet;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import rest.dto.PersonDto;
import rest.dto.WalletDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author L on 18.01.2017.
 */
@Path("people")
@Stateless
public class PeopleResources {

	Mapper mapper = new DozerBeanMapper();
	
    @PersistenceContext
    EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
    	List<PersonDto> result = new ArrayList<PersonDto>();
        System.out.println("zaczynam pobierac dane");
    	for(Person p: entityManager.createNamedQuery("person.all",Person.class).getResultList()){
        	result.add(mapper.map(p, PersonDto.class));
        }
    	
        System.out.println("koncze");
        return Response.ok(new GenericEntity<List<PersonDto>>(result){}).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/accounts") 
    public Response getpersonWallets(@PathParam("id") int personId){
    	Person p = entityManager.createNamedQuery("person.id", Person.class)
    			.setParameter("id", personId)
    			.getSingleResult();
    	if(p==null)
    		return Response.status(Status.NOT_FOUND).build();
    	List<WalletDto> results = new ArrayList<WalletDto>();
    	for(Wallet w: p.getWallets()){
    		results.add(mapper.map(w, WalletDto.class));
    	}
    	return Response.ok(new GenericEntity<List<WalletDto>>(results){}).build();
    }
    
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Add(Person person) {
        entityManager.persist(person);
        return Response.ok(person.getId()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Person p) {
        Person result = entityManager.createNamedQuery("person.id", Person.class)
                .setParameter("id", id)
                .getSingleResult();
        if (result == null) {
            return Response.status(404).build();
        }
        p.setName(p.getName());
        p.setSurname(p.getSurname());
        entityManager.persist(result);
        return Response.ok().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Person result = entityManager.createNamedQuery("person.id", Person.class)
                .setParameter("id", id)
                .getSingleResult();
        if (result == null) {
            return Response.status(404).build();
        }
        return Response.ok(result).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        Person result = entityManager.createNamedQuery("person.id", Person.class)
                .setParameter("id", id)
                .getSingleResult();
        if (result == null)
            return Response.status(404).build();
        entityManager.remove(result);
        return Response.ok().build();
    }
}
