package com.example.ui.controller;

import com.example.exceptions.UserServiceException;
import com.example.ui.model.request.UpdateUserDetailsRequestModel;
import com.example.ui.model.request.UserDetailsRequestModel;
import com.example.ui.model.response.UserRest;
import com.example.userservice.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users") //http://localhost:8080/users

public class UserController{

	Map<String, UserRest> users;

	@Autowired
	UserService userService;

	@GetMapping()
	public String getUser(@RequestParam(value = "page", defaultValue = "1") int page,
						  @RequestParam (value = "limit",defaultValue = "20") int size,
						  @RequestParam (value = "sort" , required = false, defaultValue = "desc") String sort)

	{
		return "get user was called with page " +page + " ,limit " +size + " ,sort " +sort;
	}


	@GetMapping(path = "/{userId}" ,
			produces = {
					MediaType.APPLICATION_XML_VALUE ,
					MediaType.APPLICATION_JSON_VALUE
					})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId)
	{
		if(true)
			throw new UserServiceException("A user service exception is thrown");

		if(users.containsKey(userId))
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(consumes = {
			MediaType.APPLICATION_XML_VALUE ,
			MediaType.APPLICATION_JSON_VALUE
			}, produces = {
				MediaType.APPLICATION_XML_VALUE ,
				MediaType.APPLICATION_JSON_VALUE
			})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails)
	{
		UserRest returnValue = userService.createUser(userDetails);
		return new ResponseEntity<>(returnValue, HttpStatus.OK);
	}
	
	@PutMapping(path = "/{userId}" ,consumes = {
			MediaType.APPLICATION_XML_VALUE ,
			MediaType.APPLICATION_JSON_VALUE
			}, produces = {
			MediaType.APPLICATION_XML_VALUE ,
			MediaType.APPLICATION_JSON_VALUE
			})
	public UserRest updateUser(@PathVariable String userId ,@Valid @RequestBody UpdateUserDetailsRequestModel userDetails){

		UserRest storedUserDetails = new UserRest();

		storedUserDetails.setFirstName(userDetails.getFirstName());
		storedUserDetails.setLastName(userDetails.getLastName());

		users.put(userId, storedUserDetails);

		return storedUserDetails;
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		
		users.remove(id);
		return ResponseEntity.noContent().build();

	}
}
