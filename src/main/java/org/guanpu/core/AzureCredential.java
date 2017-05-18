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
	AzureCredential(Builder builder) {

	}

	private static final String ROOT_URL = "https://login.microsoftonline.com/";
	
	private static final String OAUTH2_PATH = "OAuth2/Token";
	
	private static final String API_VERSION = "api-version=1.0";
	
	private static final String POST_GRANT_TYPE = "client_credentials";
	
	private static final String POST_RESOURCE = "https://management.core.windows.net/";
	
	
	public static final class Builder {
		
		String tenant;
		String clientId;
		String clientSecret;
		
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
