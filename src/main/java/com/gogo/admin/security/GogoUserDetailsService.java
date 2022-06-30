package com.gogo.admin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gogo.admin.domain.User;
import com.gogo.admin.repository.UserRepository;

// This class called by Spring Security when performing the authentification process
public class GogoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User userByEmail = userRepository.getUserByEmail(email);
		if (userByEmail != null) {
			return new GogoUserDetails(userByEmail);
		}
		throw new UsernameNotFoundException("No user with email: " + email);
	}
}
