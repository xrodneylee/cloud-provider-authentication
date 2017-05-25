package org.guanpu.core;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LinodeCredentialTest {
	
	LinodeCredential credential;
	Response resposne;
	JsonNode root;
	
	@Before
	public void setUp() throws Exception {
		credential = new LinodeCredential.Builder()
				.setUsername("username")
				.setPassword("password")
				.build();
		
		resposne = credential.invoke();
		root = new ObjectMapper().readTree(resposne.readEntity(String.class));
	}

	@After
	public void tearDown() throws Exception {
		resposne.close();
	}

	@Test
	public void testStatus() {
		assertEquals(200, resposne.getStatus());
	}
	
	@Test
	public void testAction() {
		assertEquals("user.getAPIKey", root.at("/ACTION").asText());
	}
	
	@Test
	public void testApiKey() {
		assertNotEquals("", root.at("/DATA/API_KEY").asText());
	}

}
