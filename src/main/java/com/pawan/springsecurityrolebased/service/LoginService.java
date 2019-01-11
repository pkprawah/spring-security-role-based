package com.pawan.springsecurityrolebased.service;

import com.pawan.springsecurityrolebased.util.APIResponse;

public interface LoginService {
	
	public APIResponse signIn(String username,String password);

}
