package com.example.springboot.service;

import java.util.List;

import com.example.springboot.entity.User;

public interface UserService {

	User createUser(User user);

	User getUserById(Long uid) throws Exception;

	List<User> getAllUsers();

	User updateUser(User updateUser);

	String deleteUser(Long uid) throws Exception;

}
