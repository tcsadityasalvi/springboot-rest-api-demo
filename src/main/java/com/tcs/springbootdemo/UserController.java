package com.tcs.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class UserController {
	
	@Autowired  //DI
	IUserService userService;
	@GetMapping("/user")
	private String getUser() {
		System.out.println("called");
		return "hello";}
		
		@GetMapping("/user")
		private Iterable<User> getUser1() {
			return userService.getAllUsers();
		
	}
	
	@PostMapping("/user")
	private void saveUser(@RequestBody User user) {
		System.out.println(user.getFirstName());
	}
	
	@PutMapping("/user") //METHOD+Path
	private void updateUser(@RequestBody User user) {
		userService.save(user);
		System.out.println(user.getFirstName());
	}

}
