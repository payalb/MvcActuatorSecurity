package com.example.demo.controller;

import org.springframework.boot.actuate.trace.http.HttpTrace.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyRestController {

	@GetMapping("/index")
	public String greeting() {
		return "index";
	}
}
