package com.example.springboot.service;

import java.util.List;

import com.example.springboot.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDtoo);

	UserDto getUserById(Long uid) throws Exception;

	List<UserDto> getAllUsers(Integer offset,Integer pageSize);

	UserDto updateUser(UserDto updateUser);

	String deleteUser(Long uid) throws Exception;

}
