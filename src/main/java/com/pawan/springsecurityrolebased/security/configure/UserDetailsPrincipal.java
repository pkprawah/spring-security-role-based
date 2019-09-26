package com.pawan.springsecurityrolebased.security.configure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pawan.springsecurityrolebased.model.Role;
import com.pawan.springsecurityrolebased.model.User;

public class UserDetailsPrincipal extends User implements UserDetails{

	 private  User user;
	
	public UserDetailsPrincipal(User user) {
		
		super(user);
		// System.out.print("call UserDetailsPrincipal -> UserDetailsPrincipal +9 ");
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 //System.out.print("call UserDetailsPrincipal -> getAuthorities +11 ");
		List<Role> roleList=(List<Role>)super.getRoles();
		List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority simpleGrantedAuthority=null;
		String roleName=null;
		for(Role role :roleList){
			roleName=role.getRoleName();
			simpleGrantedAuthority=new SimpleGrantedAuthority("ROLE_"+roleName);
			 authorities.add(simpleGrantedAuthority);
			
			
		}
		//System.out.println("role Name:"+roleName);
		  /*List<GrantedAuthority> authorities = Collections.singletonList(
				 new SimpleGrantedAuthority("ROLE_"+roleName));*/
		 System.out.print("Authorities :::"+authorities);
		 return authorities;
	}

	@Override
	public String getPassword() {
		 return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
