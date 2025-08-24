package com.example.ai_career_coach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ai_career_coach.model.User;
import com.example.ai_career_coach.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> getAllUsersService() {
		List<User> users=userRepo.findAll();
		if(users.size()==0) return null;
		return users;
	}

}
