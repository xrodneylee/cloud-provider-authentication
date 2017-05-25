package org.guanpu.core;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.common.base.Preconditions;

public class LinodeCredential {

	private final String ROOT_URL = "https://api.linode.com/";
	private final String ACTION = "user.getAPIKey";
	private final String username;
	private final String password;
	
	private LinodeCredential(Builder builder) {
		this.username = builder.username;
		this.password = builder.password;
	}
	
	public Response invoke(){
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(ROOT_URL)
					.queryParam("api_action", ACTION)
					.queryParam("username", username)
					.queryParam("password", password);
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		
		return response;
	}
	
	public static final class Builder {
		private String username;
		private String password;
		
		public LinodeCredential build(){
			Preconditions.checkNotNull(username, "username can't be null");
			Preconditions.checkNotNull(password, "password can't be null");
			return new LinodeCredential(this);
		}
		
		public Builder setUsername(String username) {
			this.username = username;
			return this;
		}
		
		public Builder setPassword(String password) {
			this.password = password;
			return this;
		}
	}
}
