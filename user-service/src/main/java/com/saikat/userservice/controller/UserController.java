package com.saikat.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saikat.userservice.VO.ResponseTemplateVO;
import com.saikat.userservice.entity.User;
import com.saikat.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User saverUser(@RequestBody User user){
		
		return userService.saverUser(user);
	}
	
//	@GetMapping("/{id}")
//	public Optional<User> findUserById(@PathVariable("id") Long userId){
//		
//		return userService.findUserById(userId);
//	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getuserWithDepartment(@PathVariable("id") Long userId) {
		
		return userService.getuserWithDepartment(userId);
	}
	
	
	
	
	
	
}
