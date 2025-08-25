package com.example.ai_career_coach.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ai_career_coach.model.User;
import com.example.ai_career_coach.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User createUserService(User newUser) {
		if(newUser==null || newUser.toString().isBlank()) {
			return null;
		}else {
			User user=userRepo.save(newUser);
			return user;
		}
	}
	
	public User deleteUserByIdService(Long id) {
		if(id!=null && id>0) {
			Optional<User> user=userRepo.findById(id);
			if(user.isPresent()) {
				userRepo.deleteById(id);
				return user.get();
			}else {
				return null;
			}
		}return null;
	}
	public User getUserByIdService(Long id) {
		if(id!=null && id>0) {
			Optional<User> user=userRepo.findById(id);
			if(user.isPresent()) {
				return user.get();
			}
			return null;
		}else {
			return null;
		}
	}
	public List<User> getAllUsersService() {
		List<User> users=userRepo.findAll();
		if(users.size()==0) return null;
		return users;
	}

}
