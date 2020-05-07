package com.sample.IdentityMicroService.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService{

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
/*
 * Im memory Authentication
 */
		List authorities = new ArrayList<>();
		//authorities.add("ADMIN");
		
		return new User("akhil", "akhil", authorities);
	}

}
