package com.example.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Game;

@RestController
@RequestMapping("/game")
public class GameResource {

	@GetMapping
	public ResponseEntity<Game> findAll(){
		Game obj = new Game(null, "God Of War", "Deus da Guerra, o jogo para mobile", 50.00);
		return ResponseEntity.ok().body(obj);
	}
}
