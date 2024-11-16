package com.gabrielpereira.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielpereira.dslist.dto.GameListDTO;
import com.gabrielpereira.dslist.entities.GameList;
import com.gabrielpereira.dslist.projections.GameMinProjection;
import com.gabrielpereira.dslist.repositories.GameListRepository;
import com.gabrielpereira.dslist.repositories.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired 
	private GameRepository gameRepository;
	
	@Transactional
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);
		
		int min = (sourceIndex < destinationIndex) ? sourceIndex : destinationIndex;
		int max = (sourceIndex > destinationIndex) ? sourceIndex : destinationIndex;
		
		for (int i = 0; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
}
