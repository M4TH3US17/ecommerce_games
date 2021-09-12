package com.example.demo.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Address;
import com.example.demo.entities.Client;
import com.example.demo.entities.Game;
import com.example.demo.entities.Order;

@RestController
@RequestMapping("/order")
public class OrderResource {

	@GetMapping
	public ResponseEntity<Order> findAll() {
		Order obj = new Order(null, 50.00, Instant.parse("2021-09-20T19:53:07Z"), 10.00, 50.00, 
				new Client(null, "Matheus Dalvino", "(92) 00000-0000", new Address(null, "av. samaúma", 517)));
		
		List<Game> game = new ArrayList<>();
		game.add(new Game(null, "God Of War", "Deus da Guerra, o jogo para mobile", 50.00));
		
		obj.setGames(game);
		return ResponseEntity.ok().body(obj);
	}
}
