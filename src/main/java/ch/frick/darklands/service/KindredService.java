package ch.frick.darklands.service;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.frick.darklands.daos.KindredDAO;
import ch.frick.darklands.daos.impl.JpaKindredDAO;
import ch.frick.darklands.data.Kindred;


@Singleton
@Path("/kindred")
public class KindredService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(KindredService.class);
	
	private KindredDAO kindredDAO;
	
	public KindredService(){
		kindredDAO = new JpaKindredDAO();
	}

	@GET
	@Path("/")
	@Produces("application/json")
	public Response getAllKindreds() throws JsonProcessingException{
		List<Kindred> allKindreds = kindredDAO.getAll();
		LOGGER.debug("Get All Kindreds: " + allKindreds.size());
		ObjectMapper mapper = new ObjectMapper();
		String jsonKindreds = mapper.writeValueAsString(allKindreds);
		return Response.ok(jsonKindreds, MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/{param}")
	@Produces("application/json")
	public Response getKindredById(@PathParam("param") Long id) throws JsonProcessingException{
		if(id == null || id < 1){
			return Response.serverError().build();
		}
		Kindred kindred = kindredDAO.getById(id);
		if(kindred == null){
			return Response.serverError().build();
		}
		ObjectMapper mapper = new ObjectMapper();
		String jsonKindreds = mapper.writeValueAsString(kindred);
		return Response.ok(jsonKindreds, MediaType.APPLICATION_JSON).build();
	}
	
}