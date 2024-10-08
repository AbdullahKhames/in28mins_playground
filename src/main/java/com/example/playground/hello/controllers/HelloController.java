package com.example.playground.hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping(value = "say-hello", method = RequestMethod.GET)
	@ResponseBody
	public String sayHello() {
		return "Hello there how are you?";
	}

	@RequestMapping(value = "say-hello-html", method = RequestMethod.GET)
	public String sayHelloHTML() {
		return "hello";
	}
}
