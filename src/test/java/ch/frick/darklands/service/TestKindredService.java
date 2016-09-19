package ch.frick.darklands.service;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import ch.frick.darklands.data.Kindred;

public class TestKindredService {
	
	private KindredService kindredService;
	private Kindred mockedList = mock(Kindred.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		kindredService = new KindredService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		try {
			Response response = kindredService.getAllKindreds();
			System.out.println(response);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			fail("Exception happened: " + e.getMessage());
		}
	}

}
