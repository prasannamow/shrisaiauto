package com.shri.sai.scooter.service;

import java.util.List;

import com.shri.sai.scooter.entity.Users;

public interface UserService {
	public Users createUser(Users users);

	public Users findUser(String username);

	public List<Users> findAllUsers();
}
