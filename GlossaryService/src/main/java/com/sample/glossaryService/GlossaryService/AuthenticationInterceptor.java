package com.sample.glossaryService.GlossaryService;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

   // private final AuthenticationService authenticationService;
	
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
        
       // sessionInfo.setHeaderParams(headerParams);

        return super.preHandle(request, response, handler);
    }
}