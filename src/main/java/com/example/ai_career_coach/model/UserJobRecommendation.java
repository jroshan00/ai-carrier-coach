package com.example.ai_career_coach.model;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_recommendations")
@Component
public class UserJobRecommendation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// User who got the recommendation
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	// The recommended job
	@ManyToOne
	@JoinColumn(name = "job_id", nullable = false)
	private Job job;

	// Match score from GPT/vector search
	private Double score;

	private final LocalDateTime createdAt = LocalDateTime.now();

}
