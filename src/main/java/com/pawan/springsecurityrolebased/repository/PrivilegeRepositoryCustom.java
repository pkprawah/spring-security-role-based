package com.pawan.springsecurityrolebased.repository;

import org.springframework.stereotype.Repository;

import com.pawan.springsecurityrolebased.model.Privilege;



@Repository
public interface PrivilegeRepositoryCustom {

	Privilege getPrivilegeByPrivilegeName(String privilegeName);
	

}
