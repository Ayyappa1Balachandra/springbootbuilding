package com.stacksimplify.restServices.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restServices.Entites.UserData;
import com.stacksimplify.restServices.Service.UserService;


@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<UserData> getAllUsers(){
		return userService.getAllUsers();
		
	}
	
	@PostMapping("/create")
	public List<UserData> createUser(@RequestBody List<UserData> user){
		return userService.createUser(user);
		
	}
	
	@GetMapping("/users/{id}")
	public Optional<UserData> getUserById(@PathVariable Long id){
		return userService.getUserById(id);
		
	}
	
	
	@PutMapping("/update/{ssn}")
	public UserData updateBySsn( String ssn, @RequestBody UserData user){
		return userService.updateBySsn(ssn,  user);
	}
	
	@PutMapping("/updateId/{id}")
	public UserData updateById(@PathVariable Long id, @RequestBody UserData user) {
		return userService.updateById(id, user);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteById(@PathVariable Long id) {
		 userService.deleteById(id);
	}
	
	@GetMapping("getUserByUserName/{userName}")
	public Optional<UserData> getUserByUserName(@PathVariable String userName) {
		return userService.getUserByUserName(userName);
	}
}
