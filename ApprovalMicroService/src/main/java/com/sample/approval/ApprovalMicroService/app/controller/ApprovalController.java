package com.sample.approval.ApprovalMicroService.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.sample.approval.ApprovalMicroService.AuthenticationRequest;





@RestController
public class ApprovalController {
	
	
	
	
	
	//@PreAuthorize("isAuthenticated()") 
	@PostMapping(value = "/admin/users", produces = MediaType.APPLICATION_JSON_VALUE)
	//@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> fetchAllAdminUserProfiles(@RequestBody AuthenticationRequest authenticationRequest) {
		// Access the JWT Token First
		
		/*
		 * Call Identity Service
		 */
		RestTemplate  restTemplate = new RestTemplate();
		System.out.println("Calling te IdentityService to fetch the Token");
		ResponseEntity<String> result =  restTemplate.postForEntity("http://locahost://8080/IdentityService/authenticate", authenticationRequest,String.class);
		//ResponseEntity<AuthenticationRequest> result = restTemplate.getForEntity("http://localhost:8080/IdentityService/authenticate", AuthenticationRequest.class);
		/*ResponseEntity<String> result = 
				restTemplate.postForEntity("http://localhost:8080/IdentityService/fetchJwtToken", 
						authenticationRequest, String.class) ;*/
		
		return result;
		//return approvalService.fetchAllAdminUserProfiles();
	}
	
	
	
	

}
