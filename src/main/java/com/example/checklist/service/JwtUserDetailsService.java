package com.example.checklist.service;

import com.example.checklist.model.UserDao;
import com.example.checklist.model.UserDto;
import com.example.checklist.repository.userRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private userRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDao userDao = this.userDao.findByUsername(username);
		if (userDao == null) {
			throw new UsernameNotFoundException("UserDao not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(userDao.getUsername(), userDao.getPassword(),
				new ArrayList<>());
	}

	public UserDao save(UserDto user) {
		UserDao newUserDao = new UserDao();
		newUserDao.setUsername(user.getUsername());
		newUserDao.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDao.save(newUserDao);
	}
}