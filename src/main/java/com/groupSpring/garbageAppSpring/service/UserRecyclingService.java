package com.groupSpring.garbageAppSpring.service;

import java.util.List;

import com.groupSpring.garbageAppSpring.model.UserRecycling;

public interface UserRecyclingService {
	UserRecycling addUserRecycling(UserRecycling ur);

	List<UserRecycling> findByName(String name);
	
	List<UserRecycling> findByMaterialname(String materialname);
	
	List<UserRecycling> getAllUserRecyclings();
}
