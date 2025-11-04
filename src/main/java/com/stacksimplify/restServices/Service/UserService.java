package com.stacksimplify.restServices.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stacksimplify.restServices.Entites.UserData;
import com.stacksimplify.restServices.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<UserData> getAllUsers(){
		return userRepository.findAll();
	}
	
	public List<UserData> createUser(List<UserData> user) {
		
		return userRepository.saveAll(user);
	}
	
	
	public Optional<UserData> getUserById(Long id) {
		Optional<UserData> user = userRepository.findById(id);
		return user;
	}

	public UserData updateBySsn(String ssn, UserData user) {
		user.setSsn(ssn);
		return userRepository.save(user);
	}

	public UserData updateById(Long id, UserData user) {
		 user.setId(id);
		 UserData update = userRepository.save(user);
		 return update;
	}

	public void deleteById(Long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
	}

	public Optional<UserData> getUserByUserName(String userName) {
		Optional<UserData> userData = userRepository.findByUserName(userName);
		return userData;
	}
	

	

}
