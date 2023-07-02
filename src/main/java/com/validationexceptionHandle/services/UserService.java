package com.validationexceptionHandle.services;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.validationexceptionHandle.dto.UserRequest;
import com.validationexceptionHandle.entity.User;
import com.validationexceptionHandle.exception.UserNotFoundException;
import com.validationexceptionHandle.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User saveUser(UserRequest userRequest) {
		User user = User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality(), userRequest.getUserType());
		return repository.save(user);
	}
	
	public List<User>getAllUser(){
		return repository.findAll();
	}
	
	public User getUser(int id) throws UserNotFoundException {
		return repository.findByUserId(id).orElseThrow(()-> new UserNotFoundException("user not found with id :"+id));
		
	}

}
