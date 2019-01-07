package com.happiestminds.springsecurityrolebased.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.happiestminds.springsecurityrolebased.model.Role;



@Repository
@Transactional
public class RoleRepositoryImpl implements CustomRoleRepository {
	
	private static final String getroleQuery ="select role.* from role role where role.RoleName=?";

	@PersistenceContext
    EntityManager entityManager;
	
	
	@Override
	public Role getRoleByRoleName(String roleName) {
		Query query = entityManager.createNativeQuery(getroleQuery,Role.class);
        query.setParameter(1, roleName);
        List<Role> roleList= (List<Role>)query.getResultList();
        if(roleList==null  || roleList.isEmpty()){
        	return null;
        }
        return roleList.get(0);
	}
}
