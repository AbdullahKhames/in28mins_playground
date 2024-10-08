package com.example.playground.hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.playground.hello.services.AuthenticationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping(value ="login")
@RequiredArgsConstructor
public class LoginController {

	private final AuthenticationService authenticationService;
	@GetMapping
	public String loginPage() {
		return "login";
	}
	
	@PostMapping
	public String submitLoginPage(
			// for query params and form data both can be captured using RequestParam
			@RequestParam String userName,
			@RequestParam String password,
			ModelMap model
			) {
		if (authenticationService.authinticate(userName, password)) {
			model.addAttribute("userName", userName);
			return "home";
		}
		return "login";
	}
}
