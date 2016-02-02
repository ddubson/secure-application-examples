package com.ddubson.poc.service;

import com.ddubson.poc.core.CustomUserDetails;
import com.ddubson.poc.model.User;
import com.ddubson.poc.repository.UserRepository;
import com.ddubson.poc.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	private final UserRepository userRepository;
	private final UserRoleRepository userRolesRepository;

	@Autowired
	public CustomUserDetailsService(UserRepository userRepository,
			UserRoleRepository userRoleRepository) {
		this.userRepository = userRepository;
		this.userRolesRepository = userRoleRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user=userRepository.findByUserName(username);
		if(null == user){
			throw new UsernameNotFoundException("No user present with username: "+username);
		}else{
			List<String> userRoles=userRolesRepository.findRoleByUserName(username);
			return new CustomUserDetails(user,userRoles);
		}
	}
}
