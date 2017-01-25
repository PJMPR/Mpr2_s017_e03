package rest;

import domain.model.History;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author L on 18.01.2017.
 */
@Path("wallet/{id}/history")
@Stateless
public class HistoryResources {

    @PersistenceContext
    EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() throws ParseException {

       
        return Response.ok().build();

    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getFromAndTo(@PathParam("id") int id, @QueryParam("dateFrom") String timeFrom
//            , @QueryParam("dateTo") String timeTo) throws ParseException {
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date dateObj = sdf.parse(timeFrom);
//        Date dateObj2 = sdf.parse(timeTo);
//
//        List<History> result = entityManager.createNamedQuery("dateBetween", History.class)
//                .setParameter("walletFrom.id", id)
//                .setParameter("dateFrom", dateObj)
//                .setParameter("dateTo", dateObj2)
//                .getResultList();
//
//        if (result == null) {
//            return Response.status(404).build();
//        }
//        return Response.ok(result).build();
//    }
}
