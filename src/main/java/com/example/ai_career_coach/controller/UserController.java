package com.example.ai_career_coach.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ai_career_coach.model.User;
import com.example.ai_career_coach.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public ResponseEntity<?> createUserController(@RequestBody User newUser) {
		User user=userService.createUserService(newUser);
		if(user!=null) {
			return ResponseEntity.ok(user);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Check the User input : "+user);
		}
	}
	
	@GetMapping("/getUserByid/{id}")
	public ResponseEntity<?> getUserByIdController(@PathVariable Long id){
		User user=userService.getUserByIdService(id);
		if(user!=null) {
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found against the input id : "+id);
	}
	
	@DeleteMapping("/deleteUserById/{id}")
	public ResponseEntity<?> deleteUserByIdController(@PathVariable Long id) {
		User user=userService.deleteUserByIdService(id);
		if(user!=null) {
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not available against input id : "+id);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllUsersController(){
		List<User> users=userService.getAllUsersService();
		if(users!=null) {
			return ResponseEntity.ok(users);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No user Available in DB");
	}
	
	
	
	
}
