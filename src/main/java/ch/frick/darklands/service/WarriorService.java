package ch.frick.darklands.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.frick.darklands.daos.WarriorDAO;
import ch.frick.darklands.daos.impl.JpaWarriorDAO;
import ch.frick.darklands.data.Token;
import ch.frick.darklands.data.Warrior;
import ch.frick.darklands.data.WarriorClass;
import ch.frick.darklands.data.WarriorUbiquity;

@Singleton
@Path("/warrior")
public class WarriorService {

	private final static Logger LOGGER = LoggerFactory.getLogger(WarriorService.class);

	private WarriorDAO warriorDAO;

	public WarriorService() {
		warriorDAO = new JpaWarriorDAO();
	}

	@GET
	@Path("/")
	@Produces("application/json")
	public Response getAllWarriors() throws JsonProcessingException {
		List<Warrior> allWarriors = warriorDAO.getAll();
		LOGGER.debug("Get All Warriors: " + allWarriors.size());
		ObjectMapper mapper = new ObjectMapper();
		String jsonWarriors = mapper.writeValueAsString(allWarriors);
		return Response.ok(jsonWarriors, MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/{param}")
	@Produces("application/json")
	public Response getWarriorById(@PathParam("param") Long id) throws JsonProcessingException {
		LOGGER.debug("Get Warrior by id: " + id);
		if (id == null || id < 1) {
			return Response.serverError().build();
		}
		Warrior warrior = warriorDAO.getById(id);
		ObjectMapper mapper = new ObjectMapper();
		String jsonWarrior = mapper.writeValueAsString(warrior);
		return Response.ok(jsonWarrior, MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/{param}/realm")
	@Produces("application/json")
	public Response getWarriorRealmInfo(@PathParam("param") Long id) throws JsonProcessingException {
		LOGGER.debug("Get WarriorRealmInfo by id: " + id);
		if (id == null || id < 1) {
			return Response.serverError().build();
		}
		List<WarriorUbiquity> realmInfos = warriorDAO.getWarriorRealmInfo(id);
		ObjectMapper mapper = new ObjectMapper();
		String jsonRealmInfos = mapper.writeValueAsString(realmInfos);
		return Response.ok(jsonRealmInfos, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/kindred/{param}")
	@Produces("application/json")
	public Response getWarriorsByKindredId(@PathParam("param") Long id) throws JsonProcessingException {
		LOGGER.debug("Get Warriors by Kindred: " + id);
		if (id == null || id < 1) {
			return Response.serverError().build();
		}
		List<Warrior> warriors = warriorDAO.getWarriorsByKindred(id);
		ObjectMapper mapper = new ObjectMapper();
		String jsonWarriors = mapper.writeValueAsString(warriors);
		return Response.ok(jsonWarriors, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/classes")
	@Produces("application/json")
	public Response getWarriorClasses() throws JsonProcessingException {
		LOGGER.debug("Get WarriorClasses");
		List<WarriorClass> warriorClasses = warriorDAO.getWarriorClasses();
		ObjectMapper mapper = new ObjectMapper();
		String jsonWarriorClasses = mapper.writeValueAsString(warriorClasses);
		return Response.ok(jsonWarriorClasses, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/tokens")
	@Produces("application/json")
	public Response getTokens() throws JsonProcessingException {
		LOGGER.debug("Get Tokens");
		List<Token> tokens = warriorDAO.getTokens();
		ObjectMapper mapper = new ObjectMapper();
		String jsonTokens = mapper.writeValueAsString(tokens);
		return Response.ok(jsonTokens, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/tokens/search")
	@Produces("application/json")
	public Response getWarriorsByToken(@Context UriInfo uriInfo) throws JsonProcessingException {
		LOGGER.debug("Get Warrios by Token");
		MultivaluedMap<String, String> tokenMap = uriInfo.getQueryParameters();
		List<String> params = new ArrayList<String>();
		for (String key : tokenMap.keySet()) {
			params.add(tokenMap.get(key).get(0));
		}

		List<Warrior> filtered = warriorDAO.getAll().stream()
				.filter(warrior -> params.stream()
						.allMatch(token -> warrior.getTokens().stream().anyMatch(c -> c.getName().equals(token))))
				.collect(Collectors.toList());

		ObjectMapper mapper = new ObjectMapper();
		String jsonWarriors = mapper.writeValueAsString(filtered);
		return Response.ok(jsonWarriors, MediaType.APPLICATION_JSON).build();
	}

}
