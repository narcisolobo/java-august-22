package com.nlobo.helloworld;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}
	
	@RequestMapping("/")
	public String hello() {
		return "Hello World!";
	}
	
	@RequestMapping("answer")
	public String answer() {
		return "42";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "session reset";
	}

}
