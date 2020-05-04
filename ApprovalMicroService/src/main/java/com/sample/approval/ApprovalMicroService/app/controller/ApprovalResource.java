package com.sample.approval.ApprovalMicroService.app.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.sample.approval.ApprovalMicroService.AuthenticationRequest;





@RestController
public class ApprovalResource {
	
	
	/*@Autowired
	RestTemplate  restTemplate;*/
	
	
	//@PreAuthorize("isAuthenticated()") 
	@PostMapping(value = "/admin/users", produces = MediaType.APPLICATION_JSON_VALUE)
	//@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> fetchAllAdminUserProfiles(HttpServletRequest request,@RequestBody AuthenticationRequest authenticationRequest) {
		// Access the JWT Token First
		
		//STEP 1:--***********************************-------------------------
		/*
		 * Call Identity Service
		 */
		String authorizationHeader = request.getHeader("Authorization");

		String userName = null;
		String jwt = null;

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt = authorizationHeader.substring(7);
			System.out.println("Token is Valid..............");
			//System.out.println("expiration::::::::: " + new Date(System.currentTimeMillis() + 10000 * 60 * 60 * 10));
			//userName = jwtUtil.extractUsername(jwt);
			//userName = jwtUtil.get
		}else {
			System.out.println("JWT Token EXPIRED:::::::::::::::");
		}
		
		
		
		RestTemplate  restTemplate = new RestTemplate();
		System.out.println("Calling te IdentityService to fetch the Token");
	//	ResponseEntity<String> result =  restTemplate.postForEntity("http://localhost://8080/IdentityService/authenticate", authenticationRequest,String.class);
		//ResponseEntity<AuthenticationRequest> result = restTemplate.getForEntity("http://localhost:8080/IdentityService/authenticate", AuthenticationRequest.class);
		/*ResponseEntity<String> result = 
				restTemplate.postForEntity("http://localhost:8080/IdentityService/fetchJwtToken", 
						authenticationRequest, String.class) ;*/
		
		ResponseEntity<String> result = new ResponseEntity<>(HttpStatus.ACCEPTED);
		return result;
	}
	
	
	@PostMapping(value = "/admin/approved/adduser", produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<AuthenticationRequest> approveAndAddUser(@RequestBody AuthenticationRequest authenticationRequest) {
		ResponseEntity<AuthenticationRequest> result = null;
		System.out.println("Calling Storage layer MicroService ");
		RestTemplate  restTemplate = new RestTemplate();
		try {
			result = restTemplate.getForEntity("http://localhost:4444/storageService/customer/add", AuthenticationRequest.class);
		}catch(Exception e) {
			System.out.println("  Exception is ::::::::: " + e.getMessage());
		}
		System.out.println("Got response from Storage layer MicroService ");
	   return result;
	}
	
	
	

}
