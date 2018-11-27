package com.groupSpring.garbageAppSpring.service;

import java.util.List;

import com.groupSpring.garbageAppSpring.model.UserRecycling;

public interface UserRecyclingService {
	UserRecycling addUserRecycling(UserRecycling ur);

	UserRecycling findByName(String name);
	
	List<UserRecycling> getAllUserRecyclings();
}
