package com.sample.IdentityMicroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sample.IdentityMicroService.model.AuthenticationRequest;
import com.sample.IdentityMicroService.model.AuthenticationResponse;
import com.sample.IdentityMicroService.model.MyUserDetailService;
import com.sample.IdentityMicroService.util.JwtTokenGenerator;

@RestController
public class IdentityResource {
	
	@Autowired
	private JwtTokenGenerator jwtTokenUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@Autowired
	private MyUserDetailService userDetailsService;
	

	String  jwt="";
	

	
	@PostMapping(value="/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(),
				authenticationRequest.getPassword())
				);
		}catch(BadCredentialsException e) {
			System.out.println(" >>> "+ authenticationManager +"  -------------  " + e.getMessage());
			throw new Exception();
		}
		
		
		final UserDetails userDetails 
		 = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		
		 jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
		
	}
	
	
	
	
	@PostMapping(value = "/fetchJwtToken")
	//@ResponseStatus(HttpStatus.OK)
    public String fetchUsersUserByID(@RequestBody AuthenticationRequest authenticationRequest) {
		
		final UserDetails userDetails 
		 = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
	   if(jwt!="") {
		  if(jwtTokenUtil.validateToken(jwt, userDetails))
			  return jwt;
		}		  
		return "";
	}
	
}