package ch.frick.darklands.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.frick.darklands.daos.KindredDAO;
import ch.frick.darklands.data.Kindred;

/**
 * @author Daniel
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TestKindredService {
	
	private static List<Kindred> kindreds;
	private static Kindred kindred;
	private static String jsonKindreds;
	private static String jsonKindred;
	
	private KindredService kindredService;
	@Mock
	private KindredDAO kindredDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		kindreds = new LinkedList<>();
		kindred = new Kindred("Fomoraic");
		kindred.setId(1l);
		kindreds.add(kindred);
		kindreds.add(new Kindred("Erainn"));
		kindreds.add(new Kindred("Norse"));
		kindreds.add(new Kindred("Infernii"));
		ObjectMapper mapper = new ObjectMapper();
		jsonKindreds = mapper.writeValueAsString(kindreds);
		jsonKindred = mapper.writeValueAsString(kindred);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		kindredDAO = mock(KindredDAO.class);
		when(kindredDAO.getAll()).thenReturn(kindreds);
		when(kindredDAO.getById(1l)).thenReturn(kindred);
		kindredService = new KindredService(kindredDAO);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllKindreds() {
		try {
			Response response = kindredService.getAllKindreds();
			assertNotNull(response);
			assertEquals(Status.OK.getStatusCode(), response.getStatus());
			assertEquals(response.getHeaderString("Content-Type"), MediaType.APPLICATION_JSON);
			assertEquals(response.getEntity(), jsonKindreds);
			verify(kindredDAO).getAll();
		} catch (JsonProcessingException e) {
			fail("Exception happened: " + e.getMessage());
		}
	}

	@Test
	public void testGetKindredById() {
		try {
			Response response = kindredService.getKindredById(0l);
			assertNotNull(response);
			assertEquals(Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
			assertEquals(response.hasEntity(), false);
			assertEquals(response.getHeaderString("Content-Type"), null);
			verify(kindredDAO, never()).getById(0l);
			
			response = kindredService.getKindredById(1l);
			assertNotNull(response);
			assertEquals(Status.OK.getStatusCode(), response.getStatus());
			assertEquals(response.getHeaderString("Content-Type"), MediaType.APPLICATION_JSON);
			assertEquals(response.getEntity(), jsonKindred);
			verify(kindredDAO).getById(1l);
		} catch (JsonProcessingException e) {
			fail("Exception happened: " + e.getMessage());
		}
	}
	
}
