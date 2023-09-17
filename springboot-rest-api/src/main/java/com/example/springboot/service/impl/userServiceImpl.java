package com.example.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.User;
import com.example.springboot.repository.UserRepository;
import com.example.springboot.service.UserService;

@Service
public class userServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long uid) throws Exception {
		User user = userRepository.findById(uid)
				.orElseThrow(() -> new Exception("Resource not Found Exception..." + uid));
		return user;
	}

	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	@Override
	public User updateUser(User updateUser) {
		User existingUser = userRepository.findById(updateUser.getId()).get();
		existingUser.setFirstName(updateUser.getFirstName());
		existingUser.setLastName(updateUser.getLastName());
		existingUser.setEmail(updateUser.getEmail());

		return userRepository.save(existingUser);
	}

	@Override
	public String deleteUser(Long uid) throws Exception {
		User existingUser = userRepository.findById(uid)
				.orElseThrow(() -> new Exception("Resource not Found Exception..." + uid));

		userRepository.deleteById(existingUser.getId());
		return "user Deleted sucessfully with user ID:" + uid;
	}

}
