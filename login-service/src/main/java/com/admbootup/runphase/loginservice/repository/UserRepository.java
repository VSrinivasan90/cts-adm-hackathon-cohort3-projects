package com.admbootup.runphase.loginservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admbootup.runphase.loginservice.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

	public User findByUsername(String username);
	
}
