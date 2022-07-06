package com.demo.emp.services;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.emp.model.CustomUserDetails;
import com.demo.emp.repo.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepository; 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		com.demo.emp.model.User user = this.userRepository.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("NO USER");
		
		return new CustomUserDetails( user);
	}

}
