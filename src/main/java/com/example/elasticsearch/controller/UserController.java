package com.example.elasticsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.elasticsearch.model.User;
import com.example.elasticsearch.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/saveuser")
	public String saveUser(@RequestBody List<User> userlist) {
		userService.saveUser(userlist);
		return "Records saved in the ES.";
	}
	
	@GetMapping(value = "/getall")
	public List<User> getAllUser() {
		return userService.findAllUsers();
	}

	@GetMapping(value = "/findbydesignation/{user-designation}")
	public List<User> getByDesignation(@PathVariable(name = "user-designation") String designation) {
		return userService.findByDesignation(designation);
	}

}
