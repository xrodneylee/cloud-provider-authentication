package org.guanpu.core;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.ws.rs.core.Response;

import junit.framework.Assert;

import org.guanpu.vo.Credential;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AzureCredentialTest {

	AzureCredential credential;
	Credential credentialVO;
	Response response;

	@Before
	public void setUp() throws Exception {
		credential = new AzureCredential.Builder()
			.setClientId("e4ec2c26-7b68-4b31-9665-b6cdeceb78a3")
			.setTenant("472613e3-303b-4ae2-afc6-6a3b2d920675")
			.setClientSecret("tD0HJEdnovFZ9ytAINVsDZnriebhLZuGtrv46W2y0g8=")
			.build();
		
		response = credential.invoke();
		
		credentialVO = new ObjectMapper()
		  .readerFor(Credential.class)
		  .readValue(response.readEntity(String.class));
	}

	@After
	public void tearDown() throws Exception {
		response.close();
	}

	@Test
	public void testStatus() {
		assertEquals(200, response.getStatus());
	}
	
	@Test
	public void testTokenType() throws JsonProcessingException, IOException {
		assertEquals("Bearer", credentialVO.getTokenType());
		assertNotNull(credentialVO.getExpiresIn());
		assertNotNull(credentialVO.getExtExpiresIn());
		assertNotNull(credentialVO.getExpiresOn());
		assertNotNull(credentialVO.getNotBefore());
		assertNotNull(credentialVO.getResource());
		assertNotNull(credentialVO.getAccessToken());
	}

}
