package com.test.api.auth.init;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.test.api.auth.security.User;
import com.test.api.auth.security.UserRepository;

@Component
public class DataInitializer implements ApplicationRunner {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		User newUser = new User();
		
		PasswordEncoder passwordEncoder;
		passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
		newUser.setUsername("test");
		newUser.setPassword(passwordEncoder.encode("test"));
		newUser.setUserType(0);
		newUser.setDate(LocalDateTime.now());
		userRepository.save(newUser);

	}
	
}
