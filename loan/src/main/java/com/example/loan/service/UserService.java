package com.example.loan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loan.model.User;
import com.example.loan.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	UserRepository userRep;
	
	//Get
	public List<User> getUserDetails()
	{
		return userRep.findAll();
	}
	
	//Save
	public User postUserDetails(User m)
	{
		return userRep.save(m);
	}
	
	//Update
	public User putUser(User s,int rno) {
		Optional<User> optional = userRep.findById(rno);
		User obj = null;
		if(optional.isPresent())
		{
			obj=optional.get();
			userRep.save(s);
		}
		return obj;
	}
	
	//Delete
	public void deleteUser(int regno)
	{
		 userRep.deleteById(regno);
	}
}
