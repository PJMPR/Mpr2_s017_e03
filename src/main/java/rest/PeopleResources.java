package rest;

import domain.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import rest.dto.PersonDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author L on 18.01.2017.
 */
@Path("/people")
@Stateless
public class PeopleResources {


	Mapper mapper = new DozerBeanMapper();
	
    @PersistenceContext
    EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonDto> getAll(){
    	List<PersonDto> result = new ArrayList<PersonDto>();
        System.out.println("zaczynam pobierac dane");
    	for(Person p: entityManager.createNamedQuery("person.all",Person.class).getResultList()){
        	result.add(mapper.map(p, PersonDto.class));
        }

        System.out.println("koncze");
        return result;
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
                .setParameter("personId", id)
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
                .setParameter("personId", id)
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
                .setParameter("personId", id)
                .getSingleResult();
        if (result == null)
            return Response.status(404).build();
        entityManager.remove(result);
        return Response.ok().build();
    }
}
