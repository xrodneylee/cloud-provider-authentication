package org.guanpu.core;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.common.base.Preconditions;

public class AzureCredential {

	/**
	 * https://login.microsoftonline.com/<tenant>/oauth2/token?api-version=1.0
	 * Header
	 *  Content-Type: application/x-www-form-urlencoded
	 * -------------------------------------------------
	 * POST
	 *  grant_type : client_credentials
	 *  resource : https://management.core.windows.net/
	 *  client_id : <appId>
	 *  client_secret : <key>
	 */

	private final String ROOT_URL = "https://login.microsoftonline.com";
	private final String OAUTH2_PATH = "OAuth2/Token";
	private final String API_VERSION_KEY = "api-version";
	private final String API_VERSION_VALUE = "1.0";
	private final String POST_GRANT_TYPE = "client_credentials";
	private final String POST_RESOURCE = "https://management.core.windows.net/";
	private final String tenant;
	private final String clientId;
	private final String clientSecret;
	
	private AzureCredential(Builder builder) {
		this.tenant = builder.tenant;
		this.clientId = builder.clientId;
		this.clientSecret = builder.clientSecret;
	}
	
	public Response invoke(){
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(ROOT_URL).path(tenant).path(OAUTH2_PATH).queryParam(API_VERSION_KEY, API_VERSION_VALUE);
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_FORM_URLENCODED);
		
		Form form = new Form().param("grant_type", POST_GRANT_TYPE)
		                .param("resource", POST_RESOURCE)
		                .param("client_id", clientId)
		                .param("client_secret", clientSecret);
		
		Response response = invocationBuilder.post(Entity.form(form));
		
		return response;
	}
	
	public static final class Builder {
		
		private String tenant;
		private String clientId;
		private String clientSecret;
		
		public AzureCredential build(){
			Preconditions.checkNotNull(tenant, "tenant can't be null");
			Preconditions.checkNotNull(clientId, "clientId can't be null");
			Preconditions.checkNotNull(clientSecret, "clientSecret can't be null");
			return new AzureCredential(this);
		}
		
		public Builder setTenant(String tenant){
			this.tenant = tenant;
			return this;
		}
		
		public Builder setClientId(String clientId){
			this.clientId = clientId;
			return this;
		}
		
		public Builder setClientSecret(String clientSecret){
			this.clientSecret = clientSecret;
			return this;
		}
	}
	
}
