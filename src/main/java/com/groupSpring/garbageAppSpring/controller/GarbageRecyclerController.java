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

import com.groupSpring.garbageAppSpring.model.User;
import com.groupSpring.garbageAppSpring.service.UserService;


@RestController
public class GarbageRecyclerController {
	@Autowired
	UserService us;
	
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
}
