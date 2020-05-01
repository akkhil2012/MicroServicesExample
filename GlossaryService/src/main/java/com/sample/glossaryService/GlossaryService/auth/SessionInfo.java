package com.sample.glossaryService.GlossaryService.auth;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import com.sample.glossaryService.GlossaryService.util.AuthConfiguration;

public class SessionInfo implements ISessionInfo, Serializable{
	
	
	private String accessToken;
    private String requestedUrl;
    //used to record the operation
    private String transactionId;
	@Override
	public String getAccessToken() {
		// TODO Auto-generated method stub
		return this.accessToken;
	}
	@Override
	public String getTransactionId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getRequestedUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public void setRequestedUrl(String requestedUrl) {
      
        this.requestedUrl = requestedUrl;
    }
	
	
	public void setTransactionId(String transactionId) {
	    
        this.transactionId = transactionId;
    }
	
	public static void toHttpSession(HttpServletRequest request, SessionInfo authSession) {
        /*if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("Calling toHttpSession with request=" + String.valueOf(request) + ", authSession="
                    + String.valueOf(authSession));
        }*/
		// WHy is Proxy used here????
        request.getSession(true).setAttribute(AuthConfiguration.SESSION_ATT_KEY, authSession);
    }
	@Override
	public String getTenantId() {
		// TODO Auto-generated method stub
		return null;
	}
}
