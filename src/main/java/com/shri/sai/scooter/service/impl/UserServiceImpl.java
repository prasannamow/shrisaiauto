package com.shri.sai.scooter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shri.sai.scooter.entity.Users;
import com.shri.sai.scooter.repository.UserRepository;
import com.shri.sai.scooter.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Users createUser(Users users) {
		return userRepository.save(users);
	}

	@Override
	public Users findUser(String username) {
		return userRepository.findByUserName(username);
	}

	@Override
	public List<Users> findAllUsers() {
		return (List<Users>) userRepository.findAll();
	}

}
