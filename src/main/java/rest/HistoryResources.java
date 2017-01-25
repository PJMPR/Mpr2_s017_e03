package rest;

import domain.model.History;
import domain.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import rest.dto.HistoryDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author L on 18.01.2017.
 */
@Path("wallet/{id}/history")
@Stateless
public class HistoryResources {

	Mapper mapper = new DozerBeanMapper();
    @PersistenceContext
    EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<HistoryDto> getAll(){
    	List<HistoryDto> result = new ArrayList<HistoryDto>();
        System.out.println("zaczynam pobierac dane");
    	for(History h: entityManager.createNamedQuery("history.all",History.class).getResultList()){
        	result.add(mapper.map(h, HistoryDto.class));
        }
        System.out.println("koncze");
        return result;
    }
}
