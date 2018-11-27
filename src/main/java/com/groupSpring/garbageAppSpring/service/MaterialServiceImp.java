package com.groupSpring.garbageAppSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupSpring.garbageAppSpring.model.Material;
import com.groupSpring.garbageAppSpring.repository.MaterialRepository;

@Service
public class MaterialServiceImp implements MaterialService{
	@Autowired
	MaterialRepository ma;
	
	@Override
	public Material register(Material m) {
		return ma.save(m);
	}

	@Override
	public Material findByName(String name) {
		return ma.findByName(name);
	}

	@Override
	public List<Material> getAllMaterials() {
		return ma.findBy();
	}
}
