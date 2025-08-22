package com.example.ai_career_coach.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ai_career_coach.model.Job;

public interface JobRepository extends JpaRepository<Job, Long>  {

}
