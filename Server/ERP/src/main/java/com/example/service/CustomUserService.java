package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dao.UserDetailsReposistory;
import com.example.model.User;


@Service
public class CustomUserService implements UserDetailsService {

	@Autowired
	UserDetailsReposistory userDetailsReposistory;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// TODO Auto-generated method stub
		User user = userDetailsReposistory.findByuserName(username);
		if (user == null) {
			throw new UsernameNotFoundException(" User Not Found with UserName " + username);
		}
		return user;
	}

}
