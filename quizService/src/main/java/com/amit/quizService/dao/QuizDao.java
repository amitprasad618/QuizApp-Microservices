package com.amit.quizService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amit.quizService.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
