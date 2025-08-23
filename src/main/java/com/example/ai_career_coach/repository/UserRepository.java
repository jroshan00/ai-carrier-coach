package com.example.ai_career_coach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ai_career_coach.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
