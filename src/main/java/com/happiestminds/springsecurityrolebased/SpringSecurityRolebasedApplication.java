package com.happiestminds.springsecurityrolebased;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.happiestminds.springsecurityrolebased","com.happiestminds.springsecurityrolebased.controller",
		"com.happiestminds.springsecurityrolebased.customRepository","com.happiestminds.springsecurityrolebased.customRepositoryImpl",
		"com.happiestminds.springsecurityrolebased.repository","com.happiestminds.springsecurityrolebased.service",
		"com.happiestminds.springsecurityrolebased.serviceImpl"})
public class SpringSecurityRolebasedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityRolebasedApplication.class, args);
	}

}

