package com.sample.IdentityMicroService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import static org.mockito.Mockito.*;

import com.sample.IdentityMicroService.jwt.JwtRequestFilter;
import com.sample.IdentityMicroService.model.MyUserDetailService;
import com.sample.IdentityMicroService.util.JwtUtilInterface;

public class JwtRequestFilterTest {

	@InjectMocks
	private JwtRequestFilter jwtRequestFilter;
	
	@Mock
	private MyUserDetailService myUserDetailsService;
	
	@Mock
	private UserDetails userDetails;
	
	@Mock
	private JwtUtilInterface jwtUtil;
	
	@Before
	public void setUp() throws Exception{
		 MockitoAnnotations.initMocks(this);
	
		 
	}
	
	@Test
	public void testUserService() {
		
		// Test for User Service
		//when(myUserDetailsService.loadUserByUsername(anyString())).thenReturn(userDetails);
		
	}
	
	
	@Test
	public void testJwtToken() {
		
		// Test for JWT Token
		when(jwtUtil.extractUsername(anyString())).thenReturn("");
		
		
	}
	
	
	//validateToken
	
	@Test
	public void testValidateJwtToken() {
		
		// Test for JWT Token
		
		when(userDetails.getPassword()).thenReturn("");
		
		when(jwtUtil.validateToken(anyString(),any(UserDetails.class))).
		   thenReturn(true);
		//verifyZeroInteractions(jwtUtil);
		verify(jwtUtil);
		
	}
	
	
	
	
	
	
	
	
}

