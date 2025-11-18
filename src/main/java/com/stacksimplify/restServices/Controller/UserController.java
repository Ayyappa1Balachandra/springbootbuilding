package com.stacksimplify.restServices.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.stacksimplify.restServices.Entites.UserData;
import com.stacksimplify.restServices.Exception.UserExistsException;
import com.stacksimplify.restServices.Exception.UserNotFoundException;
import com.stacksimplify.restServices.Service.UserService;


@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<UserData> getAllUsers(){
		try {
			return userService.getAllUsers();
		} catch(UserNotFoundException e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<List<UserData>> createUser(@RequestBody List<UserData> user, UriComponentsBuilder builder){
		try {
			List<UserData> userData = userService.createUser(user);
			HttpHeaders headers = new HttpHeaders();
			for (UserData userData2 : userData) {
				UriComponents uri = builder.path("/users/{id}").buildAndExpand(userData2.getId());
				headers.add("http://localhost:9090/users",uri.toString());
			}
			
			return new ResponseEntity<>(userData, headers, HttpStatus.CREATED);
		} catch (UserExistsException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
	}
	
	@GetMapping("/users/{id}")
	public Optional<UserData> getUserById(@PathVariable Long id){
		
		try {
			return userService.getUserById(id);
		} catch (UserNotFoundException e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
	}
	
	
	@PutMapping("/update/{ssn}")
	public UserData updateBySsn( String ssn, @RequestBody UserData user){
		return userService.updateBySsn(ssn,  user);
	}
	
	@PutMapping("/updateId/{id}")
	public UserData updateById(@PathVariable Long id, @RequestBody UserData user) {
		try {
			return userService.updateById(id, user);
		} catch (UserNotFoundException ex) {
			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
			
		}
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
