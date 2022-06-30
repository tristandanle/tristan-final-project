package com.gogo.admin.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.gogo.admin.domain.Role;

@DataJpaTest
@AutoConfigureTestDatabase( replace = Replace.NONE)
@Rollback(false) 
public class RoleRepositoryTests {
	
	@Autowired
    private RoleRepository repo;
	
	@Test
	public void testCreateFirstRole() {
		Role roleAdmin = new Role("Admin","manage everything");
	    Role savedRole = repo.save(roleAdmin);
	    assertThat(savedRole.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateManyRoles() {
		Role roleEditor = new Role("Editor","verify products and write publication");
		Role roleDirector = new Role("Director","Monitor progress toward achieving objectives and policies");
		Role roleManager = new Role("Manager","Accomplish department objectif by managing staffs");
		Role roleSalesperson = new Role("Salesperson","Keep track of inventory, provide customers product information");
		Role roleCustomerservice = new Role("Customerservice","Answering questions about a company products or services");
		
	    repo.saveAll(List.of(roleEditor, roleDirector,roleManager,roleSalesperson,roleCustomerservice));
	}
}
