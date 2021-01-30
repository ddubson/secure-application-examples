package com.ddubson.todo.api;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
public class JWTSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String readScope = "SCOPE_todo_read";
		String writeScope = "SCOPE_todo_write";

		http.cors().and().authorizeRequests(authz -> authz
				.antMatchers(HttpMethod.GET, "/todos").hasRole("todo_read")
//				.antMatchers(HttpMethod.GET, "/todos").hasAuthority(readScope)
				.antMatchers(HttpMethod.POST, "/todos").hasRole("todo_write")
//				.antMatchers(HttpMethod.POST, "/todos").hasAuthority(writeScope)
				.anyRequest().authenticated()
		).oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
	}
}
