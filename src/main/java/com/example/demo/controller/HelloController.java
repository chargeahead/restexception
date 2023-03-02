package com.example.demo.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String getMessage(String msg) throws CustomException, IOException {
		if(msg.equalsIgnoreCase("IllegalArgument")) {
			throw new IllegalArgumentException("Illegal Argument");
		}
		if(msg.equalsIgnoreCase("IOException")) {
			throw new IOException("IO exception");
		}
		if(msg.equalsIgnoreCase("Custom")) {
			throw new CustomException("My custom error message");
		}
		return "Hello "+msg;
	}
}
