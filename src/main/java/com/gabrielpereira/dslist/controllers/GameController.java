package com.gabrielpereira.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielpereira.dslist.dto.GameMinDTO;
import com.gabrielpereira.dslist.services.GameService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameService gameService;

	@GetMapping
	public List<GameMinDTO> findAll() {
		return gameService.findAll();
	}
}
