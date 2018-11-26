package com.groupSpring.garbageAppSpring.service;

import java.util.List;

import com.groupSpring.garbageAppSpring.model.User;

public interface UserService {
	User register(User u);

	User findByName(String name);
	
	List<User> getAllUsers();
}
