package com.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.models.User;
import com.store.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;

	public void registerUser(User user) 
	{
		repo.save(user);	
	}
	public User getUser(String uid) 
	{
		return repo.findById(uid).orElse(null);
	}
	public void updateUser(User user) 
	{
		repo.save(user);
	}
	public void updatePassword(String pass, String uid) 
	{
		repo.updateUserPassword(pass,uid);
	}
}
