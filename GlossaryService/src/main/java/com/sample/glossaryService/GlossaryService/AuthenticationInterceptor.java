package com.sample.glossaryService.GlossaryService;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sample.glossaryService.GlossaryService.auth.SessionInfo;
import com.sample.glossaryService.GlossaryService.auth.SessionManager;
import com.sample.glossaryService.GlossaryService.rest.annotations.Authenticated;



@Component
@Authenticated
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

   // private final AuthenticationService authenticationService;
	
	@Autowired
    private HttpServletRequest servletRequest;
	
	public AuthenticationInterceptor() {
		
	}

  //  @Autowired
  /*  public AuthenticationInterceptor(AuthenticationService authenticationService) {
      //  this.authenticationService = authenticationService;
    }*/

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
      //  User user = authenticationService.authenticate(token);
      //  request.setAttribute("user", user);
        System.out.println("----------------- Token ---------------" + token);
        
        //request.getUriInfo().getRequestUri().toString();
        System.out.println("----------------- URL  ---------------" + request.getRequestURI().toString());
        
        Enumeration<String> headerNames = request.getHeaderNames();

        List<String> builder = new ArrayList<>();
        
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            builder.add(headerName);
            Enumeration<String> headers = request.getHeaders(headerName);
            while (headers.hasMoreElements()) {
                String headerValue = headers.nextElement();
                builder.add(headerValue);
                if (headers.hasMoreElements()) {
                    builder.add(",");
                }
            }
            builder.add("\"");
        }
        
     //   System.out.println(" headers are: " + builder);
        
        for(String t : builder) {
        	System.out.println(" --> " + t);
        }
       SessionInfo sessionInfo = new SessionInfo();
       sessionInfo.setRequestedUrl(request.getRequestURL().toString());
        
       // Convert above to HASH-MAP
      // String transactionId = headers.get(HttpHeaderConstants.TRANSACTION_ID);
       String transactionId = null;
       
       if (transactionId == null) {
           // No incoming transaction ID, so generate one.
           transactionId = UUID.randomUUID().toString();
       }
       
       sessionInfo.setTransactionId(transactionId);
       
       
       SessionInfo.toHttpSession(servletRequest, sessionInfo);
       
       SessionManager.setCurrentSession(sessionInfo);
       
     //  sessionManager.setUserId(sessionInfo.getUserId());
       
       // sessionInfo.setHeaderParams(headerParams);
System.out.println("Processing req for :: access Token>>>" + sessionInfo.getAccessToken()+"      URL>>>" + sessionInfo.getRequestedUrl() );
       
        return super.preHandle(request, response, handler);
    }
}