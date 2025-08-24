package com.example.ai_career_coach.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ai_career_coach.model.User;
import com.example.ai_career_coach.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("getAllUsers")
	public ResponseEntity<?> getAllUsersController(){
		List<User> users=userService.getAllUsersService();
		if(users!=null) {
			return ResponseEntity.ok(users);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No user Available");
	}
	
}
