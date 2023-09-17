package com.example.springboot.mapper;

import com.example.springboot.dto.UserDto;
import com.example.springboot.entity.User;

import lombok.Data;

@Data
public class UserMapper {
	
	//convert the JPA User Entity to User DTO
	public static UserDto maptoUserDto(User user)
	{
		UserDto userDto=new UserDto
				(
				user.getId(),
				user.getFirstName(),
				user.getLastName(),
				user.getEmail()
				);
		return userDto;
	}
	
	//convert UserDto to Jpa User Entity
	public static User maptoUser(UserDto userDto)
	{
		User user=new User
				(userDto.getId(),
				userDto.getFirstName(),
				userDto.getLastName(),
				userDto.getEmail()
				);
		return user;
	}

}
