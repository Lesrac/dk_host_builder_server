package ch.frick.darklands.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

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

import ch.frick.darklands.daos.WarriorDAO;
import ch.frick.darklands.data.Acuity;
import ch.frick.darklands.data.CombatWeapon;
import ch.frick.darklands.data.Kin;
import ch.frick.darklands.data.Kindred;
import ch.frick.darklands.data.Privilege;
import ch.frick.darklands.data.Realm;
import ch.frick.darklands.data.Token;
import ch.frick.darklands.data.Ubiquity;
import ch.frick.darklands.data.Warrior;
import ch.frick.darklands.data.WarriorUbiquity;

@RunWith(MockitoJUnitRunner.class)
public class TestWarriorService {

	private static final Long NULL_ID = 100l;

	@MonotonicNonNull
	private static List<Warrior> warriors;
	@MonotonicNonNull
	private static String jsonWarriors;
	@MonotonicNonNull
	private static Warrior warrior;
	@MonotonicNonNull
	private static String jsonWarrior;
	@MonotonicNonNull
	private static String jsonWarriorList;

	@MonotonicNonNull
	private WarriorService warriorService;

	@Mock
	@MonotonicNonNull
	private WarriorDAO warriorDAO;

	@BeforeClass
	@EnsuresNonNull({ "warriors", "jsonWarriors", "jsonWarrior", "jsonWarriorList" })
	public static void setUpBeforeClass() throws Exception {
		warriors = new LinkedList<>();

		Token t1 = new Token("Fomoraic");
		// Token t2 = new Token("Erainn");
		// Token t3 = new Token("Tree");
		Token t4 = new Token("Beast");
		// Token t5 = new Token("Human");
		List<Token> tl1 = new LinkedList<>();
		tl1.add(t1);
		tl1.add(t4);

		Kindred k1 = new Kindred("Fomoraic");
		Kindred k2 = new Kindred("Erainn");

		warrior = new Warrior("Belech", k1, 2, 1, 1, 80, 254, "BelEk2", false);
		warrior.setId(1l);
		warrior.setTokens(tl1);
		warrior.setPrivilege(new Privilege("Noble"));
		warrior.setAcuity(new Acuity("Elite"));
		Set<Kin> kins = new HashSet<>();
		kins.add(new Kin("Scion of Belech"));
		warrior.setKin(kins);
		Realm r = new Realm("Baalor", k1);
		Ubiquity u = new Ubiquity("Unique");
		Set<WarriorUbiquity> ubiquities = new HashSet<>();
		ubiquities.add(new WarriorUbiquity(warrior, u, r, 1));

		warrior.setUbiquities(ubiquities);
		warrior.setCombatWeapons(new ArrayList<CombatWeapon>());
		warriors.add(warrior);
		warriors.add(new Warrior("Naraa", k1, 2, 1, 1, 30, 154, "Naraa", false));
		warriors.add(new Warrior("Warrior of Baalor", k1, 2, 1, 20, 30, 21, "W of WB", false));
		warriors.add(new Warrior("Mallax", k1, 2, 1, 1, 50, 54, "Mal-ax", false));
		warriors.add(new Warrior("Belech", k1, 2, 1, 1, 80, 254, "BelEk2", false));
		warriors.add(new Warrior("Belech", k1, 2, 1, 1, 80, 254, "BelEk2", false));
		warriors.add(new Warrior("Bog Beast", k2, 2, 1, 1, 80, 254, "Beast", false));
		warriors.add(new Warrior("Rundraig the Fat", k2, 2, 1, 1, 30, 80, "Fat", false));
		warriors.add(new Warrior("Maiobhanag", k2, 2, 1, 20, 30, 11, "Mahbo", false));
		warriors.add(new Warrior("Thuanagh", k2, 2, 1, 20, 30, 11, "Tua-Nagh", false));
		warriors.add(new Warrior("Catirin", k2, 2, 1, 1, 30, 64, "Cait-lun", false));

		ObjectMapper mapper = new ObjectMapper();
		jsonWarriors = mapper.writeValueAsString(warriors);
		jsonWarrior = mapper.writeValueAsString(warrior);
		List<Warrior> list = new LinkedList<>();
		list.add(warrior);
		jsonWarriorList = mapper.writeValueAsString(list);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	@RequiresNonNull({ "warriors", "warrior" })
	public void setUp() throws Exception {
		warriorDAO = mock(WarriorDAO.class);
		when(warriorDAO.getAll()).thenReturn(warriors);
		when(warriorDAO.getById(1l)).thenReturn(warrior);
		when(warriorDAO.getById(NULL_ID)).thenReturn(null);
		// Only for testcoverage
		warriorService = new WarriorService();
		warriorService = new WarriorService(null);
		// done
		warriorService = new WarriorService(warriorDAO);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@RequiresNonNull({ "warriorService", "warriorDAO", "jsonWarriors" })
	public void testGetAllWarriors() {
		try {
			Response response = warriorService.getAllWarriors();
			assertNotNull(response);
			assertEquals(Status.OK.getStatusCode(), response.getStatus());
			assertEquals(response.getHeaderString("Content-Type"), MediaType.APPLICATION_JSON);
			assertEquals(response.getEntity(), jsonWarriors);
			verify(warriorDAO).getAll();
		} catch (JsonProcessingException e) {
			fail("Exception happened: " + e.getMessage());
		}
	}

	@Test
	@RequiresNonNull({ "warriorService", "warriorDAO", "jsonWarrior" })
	public void testGetWarriorById() {
		try {
			Response response = warriorService.getWarriorById(0l);
			assertNotNull(response);
			assertEquals(Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
			assertEquals(response.hasEntity(), false);
			verify(warriorDAO, never()).getById(0l);

			response = warriorService.getWarriorById(null);
			assertNotNull(response);
			assertEquals(Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
			assertEquals(response.hasEntity(), false);
			verify(warriorDAO, never()).getById(null);

			response = warriorService.getWarriorById(NULL_ID);
			assertNotNull(response);
			assertEquals(Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
			assertEquals(response.hasEntity(), false);
			verify(warriorDAO).getById(NULL_ID);

			response = warriorService.getWarriorById(1l);
			assertNotNull(response);
			assertEquals(Status.OK.getStatusCode(), response.getStatus());
			assertEquals(response.getHeaderString("Content-Type"), MediaType.APPLICATION_JSON);
			assertEquals(response.getEntity(), jsonWarrior);

			// ObjectMapper mapper = new ObjectMapper();
			// System.out.println(response.getEntity());
			// Warrior w = mapper.readValue(response.getEntity().toString(),
			// Warrior.class);

			verify(warriorDAO).getById(1l);
		} catch (JsonProcessingException e) {
			fail("Exception happened: " + e.getMessage());
		} /*
			 * catch (IOException e) { fail("JSON to Object failed: " +
			 * e.getMessage()); }
			 */
	}

	// @Test
	public void testGetWarriorRealmInfo() {
		fail("Not yet implemented");
	}

	// @Test
	public void testGetWarriorsByKindredId() {
		fail("Not yet implemented");
	}

	// @Test
	public void testGetWarriorClasses() {
		fail("Not yet implemented");
	}

	// @Test
	public void testGetTokens() {
		fail("Not yet implemented");
	}

	@Test
	@RequiresNonNull({ "warriorService", "warriorDAO", "jsonWarriorList" })
	public void testGetWarriorsByToken() {
		UriInfo uriInfo = mock(UriInfo.class);
		MultivaluedMap<String, String> values = new MultivaluedHashMap<>();
		List<String> val1 = new LinkedList<>();
		val1.add("Fomoraic");
		List<String> val2 = new LinkedList<>();
		val2.add("Beast");
		values.put("token1", val1);
		values.put("token2", val2);
		when(uriInfo.getQueryParameters()).thenReturn(values);
		try {
			Response response = warriorService.getWarriorsByToken(uriInfo);
			assertNotNull(response);
			assertEquals(Status.OK.getStatusCode(), response.getStatus());
			assertEquals(response.getHeaderString("Content-Type"), MediaType.APPLICATION_JSON);
			assertEquals(response.getEntity(), jsonWarriorList);
			verify(warriorDAO).getAll();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
