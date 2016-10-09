package ch.frick.darklands.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
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

	private static final Long NULL_ID = 100l;

	@MonotonicNonNull
	private static List<Kindred> kindreds;
	@MonotonicNonNull
	private static Kindred kindred;
	@MonotonicNonNull
	private static String jsonKindreds;
	@MonotonicNonNull
	private static String jsonKindred;

	@MonotonicNonNull
	private KindredService kindredService;

	@Mock
	@MonotonicNonNull
	private KindredDAO kindredDAO;

	@BeforeClass
	@EnsuresNonNull({ "kindreds", "jsonKindreds", "jsonKindred" })
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
	@EnsuresNonNull({ "kindredService", "kindredDAO" })
	@RequiresNonNull({ "kindreds", "kindred" })
	public void setUp() throws Exception {
		kindredDAO = mock(KindredDAO.class);
		when(kindredDAO.getAll()).thenReturn(kindreds);
		when(kindredDAO.getById(1l)).thenReturn(kindred);
		when(kindredDAO.getById(NULL_ID)).thenReturn(null);
		// Only for testcoverage
		kindredService = new KindredService();
		kindredService = new KindredService(null);
		// done
		kindredService = new KindredService(kindredDAO);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@RequiresNonNull({ "kindredService", "kindredDAO", "jsonKindred", "jsonKindreds" })
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
	@RequiresNonNull({ "kindredService", "kindredDAO", "jsonKindred" })
	public void testGetKindredById() {
		try {
			Response response = kindredService.getKindredById(0l);
			assertNotNull(response);
			assertEquals(Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
			assertEquals(response.hasEntity(), false);
			verify(kindredDAO, never()).getById(0l);

			response = kindredService.getKindredById(null);
			assertNotNull(response);
			assertEquals(Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
			assertEquals(response.hasEntity(), false);
			verify(kindredDAO, never()).getById(null);

			response = kindredService.getKindredById(NULL_ID);
			assertNotNull(response);
			assertEquals(Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
			assertEquals(response.hasEntity(), false);
			verify(kindredDAO).getById(NULL_ID);

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
