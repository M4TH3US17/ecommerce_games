package com.example.demo.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Game;
import com.example.demo.repositories.GameRepository;

@RestController
@RequestMapping("/games")
public class GameResource {
	
	@Autowired
	private GameRepository repository;

	@GetMapping
	public ResponseEntity<List<Game>> findAll(){
		List<Game> list = repository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Game> findById(@PathVariable Long id){
		Optional<Game> obj = repository.findById(id);
		return ResponseEntity.ok().body(obj.get());
	}
}
