package rest;

import domain.model.Wallet;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import rest.dto.WalletDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/wallets")
@Stateless
public class WalletResources {

    private Mapper mapper = new DozerBeanMapper();
    @PersistenceContext
    EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<WalletDto> getAll(){
        List<WalletDto> result = new ArrayList<WalletDto>();
        System.out.println("pobieram dane");
        for(Wallet t: entityManager.createNamedQuery("wallet.all", Wallet.class).getResultList()){
            result.add(mapper.map(t, WalletDto.class));
        }
        System.out.println("done");
        return result;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Wallet result = entityManager.createNamedQuery("wallet.id", Wallet.class)
                .setParameter("id", id)
                .getSingleResult();
        if (result == null) {
            return Response.status(404).build();
        }
        WalletDto result2 = mapper.map(result, WalletDto.class);
        return Response.ok(result2).build();
    }
}
