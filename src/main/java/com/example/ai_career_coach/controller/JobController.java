package com.example.ai_career_coach.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ai_career_coach.model.Job;
import com.example.ai_career_coach.service.JobService;

@RestController
@RequestMapping("/job")
public class JobController {
	
	@Autowired
	JobService jobService;
	
	@GetMapping("/getJobById/{id}")
	public Job getJobByIdController(@PathVariable Long id) {
		return jobService.getJobByJobIdService(id);
	}
	
	@GetMapping("/getAllJobs")
	public ResponseEntity<?> getAllJobsController(){
		List<Job> jobs=jobService.getAllJobsService();
		if(jobs!=null) {
			return ResponseEntity.ok(jobs);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data Available");
		}
	}
	
	@PostMapping("/addJobs")
	public ResponseEntity<?> addJobsController(@RequestBody List<Job> jobs) {
		List<Job> joblist=jobService.addJobsService(jobs);
		if(joblist==null){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
		}else if(jobs==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Input");
		}
		return ResponseEntity.ok(joblist);
	}
	
	@PutMapping("/updateJob")
	public ResponseEntity<?> updateJobByIdController(@RequestBody Job job){
		Job res=jobService.updateJobByIdService(job);
		if(res!=null)return ResponseEntity.ok(res);
		else return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Input id is not valid in DB");
	}
	
	@DeleteMapping("/removeById/{id}")
	public ResponseEntity<?> removeJobByIdController(@PathVariable Long id) {
		Job job= jobService.removeJobByIdService(id);
		if(job!=null) {
			return  ResponseEntity.ok(job);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The given Id is not available in DB");
		}
	}
	
}
