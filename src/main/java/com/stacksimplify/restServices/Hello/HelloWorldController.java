package com.stacksimplify.restServices.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/helloworld")
	public String heeloWorld() {
		return "hello world";
	}
	
	@GetMapping("/helloBean")
	public UserDetails helloWorldBean() {
		return new UserDetails("Kalyan","Reddy","Hyderabad");
	}

}
