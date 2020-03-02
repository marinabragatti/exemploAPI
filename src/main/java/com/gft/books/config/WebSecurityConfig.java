//package com.gft.books.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("usuario").password("{noop}senha").roles("USER");
//	}
//	
//	protected void configure(HttpSecurity http) throws Exception {
//		http.
//			authorizeRequests().anyRequest().authenticated()
//			.and()
//				.httpBasic()
//			.and()
//				.csrf().disable(); 
//	}
//}
