package com.groupSpring.garbageAppSpring.service;

import java.util.List;

import com.groupSpring.garbageAppSpring.model.Material;


public interface MaterialService {
	Material register(Material m);

	Material findByName(String name);
	
	List<Material> getAllMaterials();
}
