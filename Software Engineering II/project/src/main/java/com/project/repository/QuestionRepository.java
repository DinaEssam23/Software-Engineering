package com.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.entities.Questions;

public interface QuestionRepository extends CrudRepository<Questions, Integer> {
}
