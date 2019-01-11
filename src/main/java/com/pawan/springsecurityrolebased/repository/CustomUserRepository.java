/**
 * 
 */
package com.pawan.springsecurityrolebased.repository;


import com.pawan.springsecurityrolebased.model.User;

/**
 * @author Pawan.kumar
 *
 */

public interface CustomUserRepository  {
	
	User getUserByUsername(String username);
	
}
