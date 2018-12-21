package com.example.demo.controller;

import org.springframework.boot.actuate.trace.http.HttpTrace.Principal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class PrincipalAdvice {

	@ModelAttribute("currentUser")
	public Principal principal(Principal p) {
		return p;
	}
}
