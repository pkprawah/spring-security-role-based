package com.pawan.springsecurityrolebased.configuration;

//import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.pawan.springsecurityrolebased.security.configure.WebSecurityConfigure;


public class SpringMVCWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { LoginApplicationConfig.class,WebSecurityConfigure.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		 //return new Class<?>[] { WebSecurityConfigure.class };
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/*" };
	}
	
}
