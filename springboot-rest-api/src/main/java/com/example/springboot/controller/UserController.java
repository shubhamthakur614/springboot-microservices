package com.example.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.entity.User;
import com.example.springboot.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createdUser = userService.createUser(user);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long uid) throws Exception {
		User getUser = userService.getUserById(uid);
		return ResponseEntity.ok(getUser);
	}

	@GetMapping("alluser")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = userService.getAllUsers();
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}

	@PutMapping("updateuser")
	public ResponseEntity<User> updateUser(@RequestBody User updateUser) {
		User updatedUser = userService.updateUser(updateUser);
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("{id}/delete")
	public ResponseEntity<String>deleteUser(@PathVariable("id")Long uid) throws Exception
	{
		String status=userService.deleteUser(uid);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}

}