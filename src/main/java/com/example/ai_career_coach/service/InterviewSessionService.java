package com.example.ai_career_coach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ai_career_coach.model.InterviewSession;
import com.example.ai_career_coach.repository.InterviewSessionRepository;

@Service
public class InterviewSessionService {
	@Autowired
	private InterviewSessionRepository interviewSessionRepo;
	
	public InterviewSession createInterviewSessionService(InterviewSession newInterviewSession) {
		if(newInterviewSession==null||newInterviewSession.toString().isBlank()) {
			return null;
		}else {
			InterviewSession interviewSession=interviewSessionRepo.saveAndFlush(newInterviewSession);
			if(interviewSession!=null && !(newInterviewSession.toString().isBlank())) {
				return interviewSession;
			}
			return null;
		}
	}
	
	public List<InterviewSession> getInterviewSessionOfUserServive(Long userId) {
		if(userId!=null && userId>0) {
			List<InterviewSession> session=interviewSessionRepo.findUserById(userId);
			if(session==null || session.size()==0) {
				return null;
			}
			return session;
		}
		return null;
	}
	
}
