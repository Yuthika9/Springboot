package com.example.ui.controller;
import com.example.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") //http://localhost:8080/users

public class UserController{


	@GetMapping()
	public String getUser(@RequestParam (value = "page", defaultValue = "1") int page,
						  @RequestParam (value = "limit",defaultValue = "20") int size,
						  @RequestParam (value = "sort" , required = false, defaultValue = "desc") String sort)

	{
		return "get user was called with page " +page + " ,limit " +size + " ,sort " +sort;
	}

	@GetMapping(path = "/{userId}",produces =
			{MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE
			})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId)
	{
		UserRest returnValue = new UserRest();

		returnValue.setFirstName("Yuth");
		returnValue.setLastName("Pant");
		returnValue.setEmail("yuth@pant.com");

		return new ResponseEntity<>(returnValue, HttpStatus.BAD_REQUEST);
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
