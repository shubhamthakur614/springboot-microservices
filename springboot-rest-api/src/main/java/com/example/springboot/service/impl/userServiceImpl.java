package com.example.springboot.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dto.UserDto;
import com.example.springboot.entity.User;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.mapper.AutoUserMapper;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.service.UserService;

@Service
public class userServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {

		// converting userDto to user JPA entity
//		User user = UserMapper.maptoUser(userDto);

		// using modelMapper library
//		User user = modelMapper.map(userDto, User.class);

		User user = AutoUserMapper.mapper.mapToUser(userDto);

		User save = userRepository.save(user);

		// converting user jpa Entity to UserDto
//		return UserMapper.maptoUserDto(save);

//		return modelMapper.map(save, UserDto.class);
		return AutoUserMapper.mapper.maptoUserDto(save);

	}

	@Override
	public UserDto getUserById(Long uid) throws Exception {

		User user = userRepository.findById(uid).orElseThrow(() -> new ResourceNotFoundException("User", "id", uid));

//		return UserMapper.maptoUserDto(user);
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {

		List<User> findAll = userRepository.findAll();
//		return findAll.stream().map(UserMapper::maptoUserDto).collect(Collectors.toList());
		return findAll.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public UserDto updateUser(UserDto updateUser) {
//		User user = UserMapper.maptoUser(updateUser);
		User user = modelMapper.map(updateUser, User.class);

		User existingUser = userRepository.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", user.getId()));
		existingUser.setFirstName(updateUser.getFirstName());
		existingUser.setLastName(updateUser.getLastName());
		existingUser.setEmail(updateUser.getEmail());

		User updatedUser = userRepository.save(existingUser);

//		return UserMapper.maptoUserDto(updatedUser);
		return modelMapper.map(updatedUser, UserDto.class);

	}

	@Override
	public String deleteUser(Long uid) throws Exception {
		User existingUser = userRepository.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", uid));

		userRepository.deleteById(existingUser.getId());
		return "user Deleted sucessfully with user ID:" + uid;
	}

}
