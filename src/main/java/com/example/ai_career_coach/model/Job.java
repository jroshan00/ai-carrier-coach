package com.example.ai_career_coach.model;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="jobs")
@Component
public class Job {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String company;
	private String location;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	// reference to a vector DB entry (semantic embedding)
	private String embedding_id;
	private final LocalDateTime posted_at=LocalDateTime.now();

}
