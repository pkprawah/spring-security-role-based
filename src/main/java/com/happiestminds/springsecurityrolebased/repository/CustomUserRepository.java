/**
 * 
 */
package com.happiestminds.springsecurityrolebased.repository;


import com.happiestminds.springsecurityrolebased.model.User;

/**
 * @author Pawan.kumar
 *
 */

public interface CustomUserRepository  {
	
	User getUserByUsername(String username);
	
}
