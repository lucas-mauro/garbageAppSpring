package com.groupSpring.garbageAppSpring.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.groupSpring.garbageAppSpring.model.UserRecycling;

public interface UserRecyclingRepository extends PagingAndSortingRepository<UserRecycling, Long>{
	List<UserRecycling> findByName(String name);
	
	List<UserRecycling> findByMaterialname(String materialname);
	
	List<UserRecycling> findBy();
}
