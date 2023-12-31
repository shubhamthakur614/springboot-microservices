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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.dto.UserDto;
import com.example.springboot.service.UserService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("create")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createdUser = userService.createUser(userDto);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long uid) throws Exception {
		UserDto getUser = userService.getUserById(uid);
		return ResponseEntity.ok(getUser);
	}

	@GetMapping("alluser")
	public ResponseEntity<List<UserDto>> getAllUsers(
			@RequestParam(value = "offset", defaultValue = "0", required = false) Integer offset,
			@RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageNumber) {
		List<UserDto> allUsers = userService.getAllUsers(offset, pageNumber);
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}

	@PutMapping("updateuser")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto updateUser) {
		UserDto updatedUser = userService.updateUser(updateUser);
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("{id}/delete")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long uid) throws Exception {
		String status = userService.deleteUser(uid);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

}
