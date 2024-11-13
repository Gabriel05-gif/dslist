package com.gabrielpereira.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielpereira.dslist.dto.GameListDTO;
import com.gabrielpereira.dslist.entities.GameList;
import com.gabrielpereira.dslist.repositories.GameListRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
}
