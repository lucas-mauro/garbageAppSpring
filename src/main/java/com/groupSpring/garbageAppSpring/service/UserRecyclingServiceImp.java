package com.groupSpring.garbageAppSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupSpring.garbageAppSpring.model.UserRecycling;
import com.groupSpring.garbageAppSpring.repository.UserRecyclingRepository;

@Service
public class UserRecyclingServiceImp implements UserRecyclingService {
	@Autowired
	UserRecyclingRepository urr;
	
	@Override
	public UserRecycling addUserRecycling(UserRecycling ur) {
		return urr.save(ur);
	}

	@Override
	public List<UserRecycling> findByName(String name) {
		return urr.findByName(name);
	}
	
	@Override
	public List<UserRecycling> findByMaterialname(String materialname) {
		return urr.findByMaterialname(materialname);
	}

	@Override
	public List<UserRecycling> getAllUserRecyclings() {
		return urr.findBy();
	}
}
