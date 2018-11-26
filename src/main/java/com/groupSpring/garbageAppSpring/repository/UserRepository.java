package com.groupSpring.garbageAppSpring.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.groupSpring.garbageAppSpring.model.User;

@RepositoryRestResource(exported = false)
public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	User findByName(String name);
	
	List<User> findBy();
}
