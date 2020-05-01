package com.sample.glossaryService.GlossaryService.auth;

public interface ISessionInfo {
	
	 String getAccessToken();
	 
	 String getTransactionId();
	 
	 
	 String getRequestedUrl();
	 
	 String getTenantId();

}
