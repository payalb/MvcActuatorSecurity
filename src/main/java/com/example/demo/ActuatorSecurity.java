package com.example.demo;

import org.springframework.boot.actuate.audit.AuditEventsEndpoint;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest.EndpointRequestMatcher;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(1)
@Configuration
@EnableWebSecurity
public class ActuatorSecurity extends WebSecurityConfigurerAdapter{
	public void configure(HttpSecurity http) throws Exception {

		http
			.requestMatcher(EndpointRequest.toAnyEndpoint())
			.authorizeRequests()
			.requestMatchers(EndpointRequest.to(HealthEndpoint.class)).permitAll()
			.anyRequest().authenticated()
			.and().httpBasic();
	}
}
