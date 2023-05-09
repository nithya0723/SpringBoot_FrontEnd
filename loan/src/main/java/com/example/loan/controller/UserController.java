package com.example.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.loan.model.User;
import com.example.loan.service.UserService;

@CrossOrigin("*")
@RestController

public class UserController {

	@Autowired
	UserService userSer;
	
	@GetMapping("/getUserDetails")
	public List<User> getUserDetails()
	{
		return userSer.getUserDetails();
	}
	
	@PostMapping(value="/postUserDetails")
	public User postUserDetails(@RequestBody User m)
	{
		return userSer.postUserDetails(m);
	}
	
	@PutMapping(value="/putUser/{rno}")
	public User putUser(@RequestBody User s,@PathVariable int rno)
	{
		return userSer.putUser(s,rno);
	}

	@DeleteMapping(value="/deleteUser/{rno}")
	public void deleteUser(@PathVariable("rno") int regno)
	{
		userSer.deleteUser(regno);
	}

}
