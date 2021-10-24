package com.co.store;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.co.store.models.dao.IUserDAO;
import com.co.store.models.entity.User;


@SpringBootTest
class ApiStoreApplicationTests {

	@Autowired
	private IUserDAO userDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	/**
	 * test for register encode password, its specially for a integration test
	 */
	@Test
	void registerEncoderUserTest() {
		User user = new User();
		user.setEmail("correo");
		user.setPassword(passwordEncoder.encode("testPasword"));
		
		User dbUser = userDao.save(user);
		
		assertTrue(dbUser.getPassword().equalsIgnoreCase(user.getPassword()));
	}

}
