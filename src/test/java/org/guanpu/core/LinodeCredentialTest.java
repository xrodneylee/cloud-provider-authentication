package org.guanpu.core;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LinodeCredentialTest {
	
	LinodeCredential linodeCredential;
	Response resposne;
	JsonNode root;
	
	@Before
	public void setUp() throws Exception {
		linodeCredential = new LinodeCredential.Builder()
				.setUsername("username")
				.setPassword("password")
				.build();
		
		resposne = linodeCredential.invoke();
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
	public void testApiKey() throws Exception {
		assertNotNull(root.at("/DATA/API_KEY").asText());
	}

}
