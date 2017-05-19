package org.guanpu.core;

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

	private final String ROOT_URL = "https://login.microsoftonline.com/";
	
	private final String OAUTH2_PATH = "OAuth2/Token";
	
	private final String API_VERSION = "api-version=1.0";
	
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
	
	
	public static final class Builder {
		
		private String tenant;
		private String clientId;
		private String clientSecret;
		
		public AzureCredential build(){
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
