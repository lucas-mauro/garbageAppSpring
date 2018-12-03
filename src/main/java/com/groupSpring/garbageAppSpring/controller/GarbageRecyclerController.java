package com.groupSpring.garbageAppSpring.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.groupSpring.garbageAppSpring.model.Material;
import com.groupSpring.garbageAppSpring.model.TotalMaterialRecycling;
import com.groupSpring.garbageAppSpring.model.User;
import com.groupSpring.garbageAppSpring.model.UserRecycling;
import com.groupSpring.garbageAppSpring.service.MaterialService;
import com.groupSpring.garbageAppSpring.service.UserRecyclingService;
import com.groupSpring.garbageAppSpring.service.UserService;


@RestController
public class GarbageRecyclerController {
	@Autowired
	UserService us;
	@Autowired
	MaterialService ms;
	@Autowired
	UserRecyclingService urs;
	
	@PostMapping(path = "/api/users")
	public ResponseEntity<User> registerUser(@RequestBody User u){
		User newU = us.register(u);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newU.getId())
				.toUri();
		return ResponseEntity.created(location).body(newU);
	}
	
	@GetMapping(path = "/api/users")
	public ResponseEntity<List<User>> getUsers( ){
		List<User> list = us.getAllUsers();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(path = "/api/users/{name}/")
	public ResponseEntity<User> getUser(@PathVariable(value = "name") String name){
		User p = us.findByName(name);
		
		return ResponseEntity.ok(p);
	}
	
	@PostMapping(path = "/api/materials")
	public ResponseEntity<Material> registerMaterial(@RequestBody Material m){
		Material newM = ms.register(m);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newM.getId())
				.toUri();
		return ResponseEntity.created(location).body(newM);
	}
	
	@GetMapping(path = "/api/materials")
	public ResponseEntity<List<Material>> getMaterials( ){
		List<Material> list = ms.getAllMaterials();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(path = "/api/materials/{name}/")
	public ResponseEntity<Material> getMaterial(@PathVariable(value = "name") String name){
		Material m = ms.findByName(name);
		
		return ResponseEntity.ok(m);
	}
	
	@PostMapping(path = "/api/userrecyclings")
	public ResponseEntity<UserRecycling> addUserRecyclings(@RequestBody UserRecycling ur){
		UserRecycling newUR = urs.addUserRecycling(ur);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newUR.getId())
				.toUri();
		return ResponseEntity.created(location).body(newUR);
	}
	
	@GetMapping(path = "/api/userrecyclings")
	public ResponseEntity<List<UserRecycling>> getUserRecyclings( ){
		List<UserRecycling> list = urs.getAllUserRecyclings();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(path = "/api/userrecyclings/{name}/")
	public ResponseEntity<List<UserRecycling>> getUserRecycling(@PathVariable(value = "name") String name){
		List<UserRecycling> list = urs.findByName(name);
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(path = "/api/usertotalrecyclings/{materialname}/")
	public ResponseEntity<TotalMaterialRecycling> getTotalUserRecycling(@PathVariable(value = "materialname") String materialname){
		List<UserRecycling> list = urs.findByMaterialname(materialname);
		TotalMaterialRecycling totalMaterialRecycling = new TotalMaterialRecycling();
		float total = 0;
		for(int i = 0; i < list.size(); i++) {
			total = total + (list.get(i).getMaterial().getWeight() * list.get(i).getQuantity());
		}
		totalMaterialRecycling.setMaterialname(materialname);
		totalMaterialRecycling.setTons(total);
		return ResponseEntity.ok(totalMaterialRecycling);
	}
}
