package com.happiestminds.springsecurityrolebased.serviceImpl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.happiestminds.springsecurityrolebased.model.Privilege;
import com.happiestminds.springsecurityrolebased.model.Role;
import com.happiestminds.springsecurityrolebased.model.User;
import com.happiestminds.springsecurityrolebased.repository.PrivilegeRepository;
import com.happiestminds.springsecurityrolebased.repository.RoleRepository;
import com.happiestminds.springsecurityrolebased.repository.UserRepository;
import com.happiestminds.springsecurityrolebased.service.RecordLoaderService;

@Service
@Transactional
public class RecordLoaderServiceImpl implements RecordLoaderService {

	@Autowired
	EntityManager entitymanager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PrivilegeRepository privilegeRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	/*@Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
 */


	@Override
	public void insertRecord() {
		
		System.out.println(" ::: calling RecordLoaderServiceImpl :::");

		Privilege readPrivilege = createPrivilegeIfNotFound("READ");
		Privilege writePrivilege = createPrivilegeIfNotFound("WRITE");

		List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
		createRoleIfNotFound("ADMIN", adminPrivileges);
		createRoleIfNotFound("USER", Arrays.asList(readPrivilege));

		Role adminRole = roleRepository.getRoleByRoleName("ADMIN");
		System.out.println("adminRole ::" + adminRole);
		if(adminRole!=null)
		createUserIfNotFound(adminRole);
		

	}

	private void createUserIfNotFound(Role adminRole) {
		
		User user = new User();
		user.setUserName("Test");
		User usr=userRepository.getUserByUsername(user.getUserName());
		if(usr!=null){
			user.setUserName("Pawan");
		}
		
		user.setFirstName("Test");
		user.setLastName("Test");
		user.setPassword(bCryptPasswordEncoder.encode("test"));
		user.setRoles(Arrays.asList(adminRole));
		user.setStatus("Enable");
		user.setEmail("test@testmail.com");
		user.setMobileNo("9999999999");
		user.setCreatedBy("Admin");
		user.setModifiedBy("Admin");
		userRepository.save(user);
	}

	private Privilege createPrivilegeIfNotFound(String name) {

		Privilege privilege = null;
		privilege = privilegeRepository.getPrivilegeByPrivilegeName(name);
		System.out.println("services ::" + privilege);
		if (privilege == null) {
			privilege = new Privilege();
			privilege.setPrivilegeName(name);
			privilege.setStatus("Enable");
			privilege.setDescription(name.toUpperCase() + "_PRIVILEGE");
			privilege.setCreatedBy("Admin");
			privilege.setModifiedBy("Admin");
			privilegeRepository.save(privilege);
		}
		return privilege;
	}

	private Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {
		System.out.println(" :: Calling createRoleIfNotFound ::");
		Role  role = new Role();
		Role rolevalue = roleRepository.getRoleByRoleName(name);
		System.out.println("In Services Role::" + role);
		if (rolevalue == null) {
		role.setRoleName(name);
		System.out.println("role name ::: "+role.getRoleName());
			role.setStatus("Enable");
			role.setDescription("ROLE_" + name.toUpperCase());
			role.setPrivileges(privileges);
			role.setCreatedBy("Admin");
			role.setModifiedBy("Admin");
			roleRepository.save(role);

		}
		return role;
	}

	 @Bean 
	 public PasswordEncoder passwordEncoder()
	 { 
		 PasswordEncoder encoder= new BCryptPasswordEncoder();
	 System.out.println("Password Instance ::"+encoder);
		 return encoder;

	 }
	 

}
