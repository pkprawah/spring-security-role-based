package com.pawan.springsecurityrolebased;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.pawan.springsecurityrolebased","com.pawan.springsecurityrolebased.controller",
		"com.pawan.springsecurityrolebased.customRepository","com.pawan.springsecurityrolebased.customRepositoryImpl",
		"com.pawan.springsecurityrolebased.repository","com.pawan.springsecurityrolebased.service",
		"com.pawan.springsecurityrolebased.serviceImpl","com.pawan.springsecurityrolebased.security.configure"})
public class SpringSecurityRolebasedApplication {

	public static void main(String[] args) {
	
		SpringApplication.run(SpringSecurityRolebasedApplication.class, args);
	}

}

