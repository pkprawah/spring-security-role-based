package com.pawan.springsecurityrolebased.repository;


import org.springframework.stereotype.Repository;

import com.pawan.springsecurityrolebased.model.Role;


@Repository
public interface CustomRoleRepository {
	
	Role getRoleByRoleName(String roleName);
	
	Role getRoleByUserName(String username);
	
	
	

}
