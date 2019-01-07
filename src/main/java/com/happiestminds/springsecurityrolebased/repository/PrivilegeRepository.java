package com.happiestminds.springsecurityrolebased.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.happiestminds.springsecurityrolebased.model.Privilege;


@Repository
public interface PrivilegeRepository extends PrivilegeRepositoryCustom, JpaRepository<Privilege, Long> {

}
