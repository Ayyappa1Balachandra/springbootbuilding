package com.stacksimplify.restServices.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stacksimplify.restServices.Entites.UserData;
import com.stacksimplify.restServices.Exception.UserExistsException;
import com.stacksimplify.restServices.Exception.UserNotFoundException;
import com.stacksimplify.restServices.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<UserData> getAllUsers() throws UserNotFoundException{
		List<UserData> users = userRepository.findAll();
		if(!users.isEmpty()) {
			throw new UserNotFoundException("User Not Found in User Repository");
		}
		return users;
	}
	
	public List<UserData> createUser(List<UserData> user) throws UserExistsException {
		
		List<UserData> existingUser = new ArrayList<>();
		for (UserData userData : user) {
			if(userRepository.existsByUserName(userData.getUserName())) {
				existingUser.add(userData);
				
			}
		}
		if(!existingUser.isEmpty()) {
			throw new UserExistsException("User Already exists in Repository"+existingUser);
		}
		
		
		return userRepository.saveAll(existingUser);
	}
	
	
	public Optional<UserData> getUserById(Long id) throws UserNotFoundException {
		Optional<UserData> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User Not Found in user Repository");
		}
		return user;
	}

	public UserData updateBySsn(String ssn, UserData user) {
		user.setSsn(ssn);
		return userRepository.save(user);
	}

	public UserData updateById(Long id, UserData user) throws UserNotFoundException {
		Optional<UserData> optionaluser = userRepository.findById(id);
		if(!optionaluser.isPresent()) {
			throw new UserNotFoundException
			("User Not Found in User Repository, provide the correct user id");
		}
			
		
		 user.setId(id); 
		 return userRepository.save(user);
	}

	public void deleteById(Long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
	}

	public Optional<UserData> getUserByUserName(String userName)  {
		Optional<UserData> userData = userRepository.findByUserName(userName);
		return userData;
	}
	

	

}
