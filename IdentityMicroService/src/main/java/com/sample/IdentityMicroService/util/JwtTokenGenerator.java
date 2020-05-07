package com.sample.IdentityMicroService.util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Service
public class JwtTokenGenerator {
	 private String SECRET_KEY = "secret";
	    public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);
	    }
	    public Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);
	    }
	    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = extractAllClaims(token);
	        return claimsResolver.apply(claims);
	    }
	    private Claims extractAllClaims(String token) {
	    	Claims c = null;
	    	try {
	          c =  Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	    	}catch (ExpiredJwtException e) {
	    		System.out.println("reason: " + e.getMessage());
	            System.out.println(" Token expired ");
	        } catch (SignatureException e) {
	        	System.out.println(" Sign had  expired ");
	           // Logger.getLogger(JWTController.class.getName()).log(Level.ERROR, e);
	        } catch(Exception e){
	            System.out.println(" Some other exception in JWT parsing ");
	        }
	    	return c;
	    }
	    private Boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }
	    public String generateToken(UserDetails userDetails,Authentication authentication) {
	        Map<String, Object> claims = new HashMap<>();
	       
	        return createToken(claims, userDetails.getUsername(),authentication);
	    }
	    private String createToken(Map<String, Object> claims, String subject,Authentication authentication) {
	    	final String authorities = authentication.getAuthorities().stream()
	                .map(GrantedAuthority::getAuthority)
	                .collect(Collectors.joining(","));
	    	
	        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
	        		.claim("AUTHORITIES_KEY", authorities)
	                 .setExpiration(new Date(System.currentTimeMillis() + 10000 * 60 * 60 * 10))
	                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	    }
	    public Boolean validateToken(String token, UserDetails userDetails) {
	        final String username = extractUsername(token);
	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	    }
	    
}