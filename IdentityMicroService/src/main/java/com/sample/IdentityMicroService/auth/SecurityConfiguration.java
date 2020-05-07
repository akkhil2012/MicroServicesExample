package com.sample.IdentityMicroService.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sample.IdentityMicroService.jwt.JwtRequestFilter;

@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	
	// To configure Authentication...........
	/*
	 * (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
	 */
	/*  In Memory Authentication
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		//Case1:  InMemory Authentication
		auth.inMemoryAuthentication()
		   .withUser("akhil")
		   .password("akhil")
		   .roles("USER");
		   /*.and()
		   .withUser("gupta")
		   .password("gupta")
		   .roles("ADMIN");*/
		
		auth.inMemoryAuthentication().withUser("gupta").password("gupta").roles("ADMIN");
			
		
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();// This is plain text and NOT an encoder
	}
	
	
	
	// TO configure Authorization
	/*protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		    .antMatchers("/").permitAll()
		    .antMatchers("/workFlowService/*").hasRole("USER")
		    .and().formLogin();
		
	}*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable()
		  .authorizeRequests().antMatchers("/authenticate").permitAll()
		  .antMatchers("/admin").access("hasRole('ADMIN')")
		  .anyRequest().authenticated()
		  .and().sessionManagement()
		  .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class);
		
	}
	
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		
		return super.authenticationManagerBean();
	}
	
}
	
	
	
	
	
	
	
	
	
	
