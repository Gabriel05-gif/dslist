package com.gabrielpereira.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielpereira.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}