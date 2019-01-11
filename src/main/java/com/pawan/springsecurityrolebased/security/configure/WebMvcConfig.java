package com.pawan.springsecurityrolebased.security.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebMvcConfig implements WebMvcConfigurer{

	 @Autowired
	    private PasswordEncoder passwordEncoder; 
	@Bean
    public PasswordEncoder passwordEncoder() {
		 //System.out.print("call WebMvcConfig -> passwordEncoder +7 ");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
}
}
