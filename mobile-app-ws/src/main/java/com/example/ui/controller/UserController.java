package com.example.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users") //http://localhost:8080/users

public class UserController{
	
	
	@GetMapping()
	public String getUser(@RequestParam (value = "page", defaultValue = "1") int page,
						  @RequestParam (value = "limit",defaultValue = "20") int size,
						  @RequestParam (value = "sort" , required = false, defaultValue = "desc") String sort)

	{
		return "get user was called with page " +page + " ,limit " +size + " ,sort " +sort;
	}

	@GetMapping(path = "/users/{userId}")
	public String getUser(@PathVariable String userId)
	{
		return "get user was called with userId: " + userId;
	}
	
	@PostMapping
	public String createUser()
	{
		return "create user was called";
	}
	
	@PutMapping
	public String updateUser(){
		
		return "update user was called";
		
	}
	
	@DeleteMapping
	public String deleteUser() {
		
		return "delete user was called";
	}
}
