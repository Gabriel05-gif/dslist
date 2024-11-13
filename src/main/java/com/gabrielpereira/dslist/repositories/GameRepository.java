package com.gabrielpereira.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielpereira.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}