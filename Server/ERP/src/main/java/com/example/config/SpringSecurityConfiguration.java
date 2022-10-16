package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.service.CustomUserService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserService customUserService;

	@Autowired
	private JWTTokenHelper jwtTokenHelper;

	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// In Memory Authentication With UserName and Password
//		auth.inMemoryAuthentication().withUser("test").password(passwordEncoder().encode("Admin@123"))
//				.authorities("User", "Admin");

		// Database Authentication
	  	auth.userDetailsService(customUserService).passwordEncoder(passwordEncoder());

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Public access for all API
		 http.authorizeRequests().anyRequest().permitAll();

		// No access for any API
		// http.authorizeRequests().anyRequest().authenticated();

//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
//				.authenticationEntryPoint(authenticationEntryPoint).and()
//				.authorizeRequests((request) -> request.antMatchers("/api/v1/auth/login").permitAll().antMatchers(HttpMethod.OPTIONS,"/**").permitAll().anyRequest().authenticated())
//				.addFilterBefore(new JWTAuthenticationFilter(customUserService, jwtTokenHelper),
//						UsernamePasswordAuthenticationFilter.class);

		// To override Security we are using form login for enter crendientals
		//http.formLogin();

		// Basic Authentication with Username and password
		//http.httpBasic();
		
		
		http.cors();
		
		http.csrf().disable().headers().frameOptions().disable();
	}

}
