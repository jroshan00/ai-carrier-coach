package com.example.ai_career_coach.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ai_career_coach.model.InterviewSession;
import com.example.ai_career_coach.service.InterviewSessionService;

@RestController
@RequestMapping("/interviewSession")
public class InterviewSessionController {
	
	@Autowired
	private InterviewSessionService interviewSessionService;
	
	@PostMapping("/createInterviewSession")
	public ResponseEntity<?> createInterviewSessionController(@RequestBody InterviewSession newSession){
		InterviewSession session=interviewSessionService.createInterviewSessionService(newSession);
		if(session!=null) {
			return ResponseEntity.ok(session);
		}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).
					body("Invalid Interview Session, please check if user is available against userid : "+newSession.getUser().getId());
	}
	
	@GetMapping("/getInterviewSessionOfUser/{userId}")
	public ResponseEntity<?> getInterviewSessionOfUserController(@PathVariable	Long userId){
		List<InterviewSession> sessions=interviewSessionService.getInterviewSessionOfUserServive(userId);
		if(sessions!=null) {
			return ResponseEntity.ok(sessions);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please re-check the userId :"+userId);
	}
	
}
