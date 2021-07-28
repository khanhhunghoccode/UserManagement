package com.mockproject.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.mockproject.repository.UserRepository;

public class UserService {

	@Autowired
	UserRepository repo;
	
	
}
