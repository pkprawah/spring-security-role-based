package com.happiestminds.springsecurityrolebased.repository;


import org.springframework.stereotype.Repository;
import com.happiestminds.springsecurityrolebased.model.Role;


@Repository
public interface CustomRoleRepository {
	
	Role getRoleByRoleName(String roleName);
	
	
	

}
