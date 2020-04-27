package com.sample.IdentityMicroService.util;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface JwtUtilInterface {
	
	
	public String extractUsername(String token);
	
	public Boolean validateToken(String token, UserDetails userDetails);
	
	

}
