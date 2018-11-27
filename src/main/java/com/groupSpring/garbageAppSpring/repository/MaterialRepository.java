package com.groupSpring.garbageAppSpring.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.groupSpring.garbageAppSpring.model.Material;

@RepositoryRestResource(exported = false)
public interface MaterialRepository extends PagingAndSortingRepository<Material, Long>{
	Material findByName(String name);
	
	List<Material> findBy();
}
