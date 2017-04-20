package com.project.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.entities.Game;

public interface GameRepository extends CrudRepository<Game, Integer> {
}
