package ch.frick.darklands.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

@RunWith(MockitoJUnitRunner.class)
public class TestKindredService {
	
	private static List<Kindred> kindreds;
	private static String jsonKindreds;
	
	private KindredService kindredService;
	@Mock private KindredDAO kindredDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		kindreds = new LinkedList<>();
		kindreds.add(new Kindred("Fomoraic"));
		kindreds.add(new Kindred("Erainn"));
		kindreds.add(new Kindred("Norse"));
		kindreds.add(new Kindred("Infernii"));
		ObjectMapper mapper = new ObjectMapper();
		jsonKindreds = mapper.writeValueAsString(kindreds);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		kindredDAO = mock(KindredDAO.class);
		when(kindredDAO.getAll()).thenReturn(kindreds);
		kindredService = new KindredService(kindredDAO);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			Response response = kindredService.getAllKindreds();
			assertNotNull(response);
			assertEquals(200, response.getStatus());
			assertEquals(response.getHeaderString("Content-Type"), MediaType.APPLICATION_JSON);
			assertEquals(response.getEntity(), jsonKindreds);
			verify(kindredDAO).getAll();
		} catch (JsonProcessingException e) {
			fail("Exception happened: " + e.getMessage());
		}
	}

}
