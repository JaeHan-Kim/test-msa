package com.test.api.auth.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserInformationService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("User Id not found");
		}
		return makeLoginUser(user);
	}

	public UserInformation makeLoginUser(User user) {
		UserInformation loginUser = new UserInformation();
		
		List<GrantedAuthority> authorityList = new ArrayList<>();
		
		switch (user.getUserType()) {
		case 0:
			authorityList.add(new SimpleGrantedAuthority("ADMIN"));
			break;
		case 1:
			authorityList.add(new SimpleGrantedAuthority("USER"));
			break;
		}
		
		loginUser.setUsername(user.getUsername());
		loginUser.setPassword(user.getPassword());
		loginUser.setAuthorities(authorityList);
		
		return loginUser;
	}
}
