package org.guanpu.vo;

import com.fasterxml.jackson.annotation.JsonSetter;

public class Credential {
	private String tokenType;
	private String expiresIn;
	private String extExpiresIn;
	private String expiresOn;
	private String notBefore;
	private String resource;
	private String accessToken;
	
	public String getTokenType() {
		return tokenType;
	}
	
	@JsonSetter("token_type")
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	
	public String getExpiresIn() {
		return expiresIn;
	}
	
	@JsonSetter("expires_in")
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}
	
	public String getExtExpiresIn() {
		return extExpiresIn;
	}
	
	@JsonSetter("ext_expires_in")
	public void setExtExpiresIn(String extExpiresIn) {
		this.extExpiresIn = extExpiresIn;
	}
	
	public String getExpiresOn() {
		return expiresOn;
	}
	
	@JsonSetter("expires_on")
	public void setExpiresOn(String expiresOn) {
		this.expiresOn = expiresOn;
	}
	
	public String getNotBefore() {
		return notBefore;
	}
	
	@JsonSetter("not_before")
	public void setNotBefore(String notBefore) {
		this.notBefore = notBefore;
	}
	
	public String getResource() {
		return resource;
	}
	
	@JsonSetter("resource")
	public void setResource(String resource) {
		this.resource = resource;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	
	@JsonSetter("access_token")
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
}
