package com.example.ai_career_coach.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ai_career_coach.model.Job;
import com.example.ai_career_coach.repository.JobRepository;

@Service
public class JobService {

	@Autowired
	JobRepository jobRepository;

	public Job getJobByJobIdService(Long id) {
		Optional<Job> opt = jobRepository.findById(id);
		if (opt.isPresent())return opt.get();
		return null;
	}

	public List<Job> addJobsService(List<Job> jobs) {
		if (jobs == null)return null;
		return jobRepository.saveAll(jobs);
	}
	
	public List<Job> getAllJobsService(){
		try {
		return jobRepository.findAll();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Job updateJobByIdService(Job job) {
		Optional<Job> opt=jobRepository.findById(job.getId());
		if(opt.isPresent()) {
			return jobRepository.save(job);
		}
		return null;
	}

	public Job removeJobByIdService(@PathVariable Long id) {
		Optional<Job> opt=jobRepository.findById(id);
		if(opt.isPresent()) {
			try {
				jobRepository.deleteById(id);
				return opt.get();
			} catch (IllegalArgumentException | OptimisticLockingFailureException e) {
				System.out.println(e.getMessage());
				return null;
			}	
		}
		return null;
	}

}
