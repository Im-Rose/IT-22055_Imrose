package com.example.banglaquiz.repository;

import com.example.banglaquiz.model.QuizScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizScoreRepository extends JpaRepository<QuizScore, Integer> {
}
