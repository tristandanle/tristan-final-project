package com.gogo.admin.repository;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

import com.gogo.admin.domain.Role;
import com.gogo.admin.domain.User;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUserWithOneRole() {
		Role roleAdmin = entityManager.find(Role.class, 1);
		User userTest1 = new User("test1@mail.com","12345678","Test1F","Test1L");
	    userTest1.addRole(roleAdmin);
	    
	    User savedUser = userRepository.save(userTest1);
	    
	    assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateUserWithMoreThanOneRole() {
		User userTest2 = new User("test2@mail.com","12345678","Test2F","Test2L");

		Role roleEditor = new Role(2);
	    Role roleDirector = new Role(3);
	    userTest2.addRole(roleDirector);    
	    userTest2.addRole(roleEditor);    
	    
	    User savedUser = userRepository.save(userTest2);
	    
	    assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testListAllUsersInDb() {
		Iterable<User> listUsers = userRepository.findAll();
        listUsers.forEach(user -> System.out.println(user));
        
	    assertThat(listUsers);
	}
	
	@Test
	public void testGetUserById() {
		User userTest1 = userRepository.findById(1).get();
		System.out.println(userTest1);
		
        assertThat(userTest1).isNotNull();
	}
	
	
	@Test
	public void testUpdateUserById() {
		User userTest1 = userRepository.findById(1).get();
		userTest1.setEnabled(true);
		userTest1.setEmail("test1@gmail.com");
		
		userRepository.save(userTest1);
	}
	
	
	@Test
	public void testUpdateRolesToUser() {
		User userTest2 = userRepository.findById(2).get();
		 Role roleDirector = new Role(3);
		 Role roleManager = new Role(4);
			
		 userTest2.getRoles().remove(roleDirector );
		 userTest2.addRole(roleManager);
		
		 userRepository.save(userTest2);
	}
	
	@Test
	public void testDeleteUserById() {
		Integer userId = 2;
		userRepository.deleteById(userId);
	}
	
	@Test
	public void testGetUserByEmail() {
		String email = "test2@mail.com";
		User user = userRepository.getUserByEmail(email);
		
		assertThat(user).isNotNull();
	}
	
	@Test
	public void testCountById() {
		Integer id = 1;
		Long coutById = userRepository.countById(id);
		
		assertThat(coutById).isNotNull().isGreaterThan(0);
	}
	
	@Test
	public void testEnableUser() {
		Integer userId = 30;
		userRepository.updateEnabledStatus(userId, true);
	}
	
	
	@Test
	public void testTreeUsersForFirstPage() {
		int pageNumber = 0;
		int pageSize = 3;
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<User> page = userRepository.findAll(pageable);
		
		List<User> listUsers = page.getContent();
		
		listUsers.forEach(user -> System.out.println(user));
		
		assertThat(listUsers.size()).isEqualTo(pageSize);
	}
	
}
