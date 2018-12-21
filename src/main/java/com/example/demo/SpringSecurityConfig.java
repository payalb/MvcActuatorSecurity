package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
//	@Autowired CustomAuthenticationProvider customAuthProvider;
	@Autowired MyUserDetailService userDetailsService;
	protected void configure(HttpSecurity http) throws Exception {
//first resricted check: SecurityExpressionRoot.java has exp language for access
		http
			.authorizeRequests()
				.mvcMatchers(HttpMethod.GET,"/index").access("hasRole('ADMIN')")
				.anyRequest().permitAll()
				.and().formLogin().and().logout()
				.and()
			.httpBasic();
		//mvcmatcher may match foo.php, foo.html .. whereas antmatcher is very precise
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	//	auth.authenticationProvider(customAuthProvider);
		
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}
