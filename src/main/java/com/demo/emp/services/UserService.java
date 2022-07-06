package com.demo.emp.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.emp.model.User;


@Service
public class UserService {

	List<User> list=new ArrayList<>();
	public  UserService() {
		list.add(new User("abc","abc","abc@gmail.com","NORMAL"));
		list.add(new User("xyz","xyz","xyz@gmail.com","ADMIN"));
		
	}
	
//	get all users 
	public List<User> getAllUsers(){
		return this.list;
	}
	
//	get the single user
	public User getUser(String username) {
		return this.list.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
	}
	
//	add new user
	public User addUser(User user){
		this.list.add(user);
		return user;
	}
}
