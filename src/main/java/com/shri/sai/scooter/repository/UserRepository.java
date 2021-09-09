package com.shri.sai.scooter.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shri.sai.scooter.entity.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer>{
	public Users findByUserName(String userName);
}
