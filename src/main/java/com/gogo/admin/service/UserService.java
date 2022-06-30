package com.gogo.admin.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer.UserInfoEndpointConfig;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.gogo.admin.UserNotFoundException;
import com.gogo.admin.domain.Role;
import com.gogo.admin.domain.User;
import com.gogo.admin.repository.RoleRepository;
import com.gogo.admin.repository.UserRepository;

@Service
@Transactional
public class UserService {
	public static final int USERS_PER_PAGE = 4;
	@Autowired
     private UserRepository userRepository;
     
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User getUserByEmail(String email) {
		// User userByEmail = userRepository.getUserByEmail(email);
		return userRepository.getUserByEmail(email);
	}
	public List<User> listAllUsers() {
		         return (List<User>) userRepository.findAll(Sort.by("lastName").ascending());
	}
	
	// list number users per page
	public Page<User> listByPage(int pageNum, String sortField, String sortDir) {
		Sort sort = Sort.by(sortField);
		
		sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
				
		Pageable pageable = PageRequest.of(pageNum - 1, USERS_PER_PAGE, sort);
		
		return userRepository.findAll(pageable);
	}
	
	public List<Role> listRoles() {
		        return (List<Role>) roleRepository.findAll();
	}

	
	public User saveUser(User user) {
        boolean isUpdatingUser = (user.getId() != null);   
		if(isUpdatingUser) {
			 User existingUserInDb = userRepository.findById(user.getId()).get();
			 if(user.getPassword().isEmpty()) {
				 user.setPassword(existingUserInDb.getPassword());
		     } else {
			     encodePassword(user);
		     }
		 } else {	 
			 encodePassword(user);
	     }
		 return userRepository.save(user);
	}
	
	public User updateAccount(User userInAccountForm) {
		User userInDb = userRepository.findById(userInAccountForm.getId()).get();
		if (!userInAccountForm.getPassword().isEmpty()) {
			userInDb.setPassword(userInAccountForm.getPassword());
			encodePassword(userInDb);
		}
		
		if (userInAccountForm.getPhotos() !=null) {
			userInDb.setPhotos(userInAccountForm.getPhotos());
		}
		
		userInDb.setFirstName(userInAccountForm.getFirstName());
        userInDb.setLastName(userInAccountForm.getLastName());		
        
        return userRepository.save(userInDb);
	}
	
	private void encodePassword(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
	}
	
	
	// Find user by id
	public User get(Integer id) throws UserNotFoundException {
		try {
			return userRepository.findById(id).get();
			
		} catch (NoSuchElementException ex) {
			throw new UserNotFoundException("No user with ID: " + id );
		}
	}
	
	// Delete user
	public void deleteUserById(Integer id) throws UserNotFoundException {
		Long countById = userRepository.countById(id);
	    if (countById == null || countById == 0) {
	    	throw new UserNotFoundException("No user with Id " + id);
	    }
	    userRepository.deleteById(id);
	}
	
	public void updateUserEnabledStatus(Integer id, boolean enable) {
		userRepository.updateEnabledStatus(id, enable);
	}
}
