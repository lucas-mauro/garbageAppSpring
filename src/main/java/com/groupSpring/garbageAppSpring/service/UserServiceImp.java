package com.groupSpring.garbageAppSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupSpring.garbageAppSpring.model.User;
import com.groupSpring.garbageAppSpring.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	UserRepository us;
	
	@Override
	public User register(User u) {
		return us.save(u);
	}

	@Override
	public User findByName(String name) {
		return us.findByName(name);
	}

	@Override
	public List<User> getAllUsers() {
		return us.findBy();
	}

}
