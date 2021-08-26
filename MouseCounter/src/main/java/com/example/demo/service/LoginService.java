package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserMapper;

@Service
public class LoginService {

	@Autowired
	UserMapper userMapper;
	
	public void findByUserId(String user_id) {
		userMapper.select(user_id);
	}
}
