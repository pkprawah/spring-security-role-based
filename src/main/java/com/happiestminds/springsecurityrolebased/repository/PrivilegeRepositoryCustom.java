package com.happiestminds.springsecurityrolebased.repository;

import org.springframework.stereotype.Repository;

import com.happiestminds.springsecurityrolebased.model.Privilege;



@Repository
public interface PrivilegeRepositoryCustom {

	Privilege getPrivilegeByPrivilegeName(String privilegeName);
	

}
