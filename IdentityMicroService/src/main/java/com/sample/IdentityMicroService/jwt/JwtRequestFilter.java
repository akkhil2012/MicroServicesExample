package com.sample.IdentityMicroService.jwt;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sample.IdentityMicroService.auth.JWTUserDetailsService;
import com.sample.IdentityMicroService.model.MyUserDetailService;
import com.sample.IdentityMicroService.util.JwtTokenGenerator;
import com.sample.IdentityMicroService.util.JwtUtilInterface;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{
	
	@Autowired
	private MyUserDetailService myUserDetailService;
	
	@Autowired
	private JwtTokenGenerator jwtUtil;

	@Autowired
	private JWTUserDetailsService jwtService;


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String authorizationHeader = request.getHeader("Authorization");

		String userName = null;
		String jwt = null;

		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwt = authorizationHeader.substring(7);
			System.out.println("expiration::::::::: " + new Date(System.currentTimeMillis() + 10000 * 60 * 60 * 10));
			userName = jwtUtil.extractUsername(jwt);
			//userName = jwtUtil.get
		}

		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.jwtService.loadUserByUsername(userName);

			if (jwtUtil.validateToken(jwt, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}

		filterChain.doFilter(request, response);
	}

}
