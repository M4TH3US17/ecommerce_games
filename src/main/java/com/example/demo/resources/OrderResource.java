package com.example.demo.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Order;
import com.example.demo.repositories.OrderRepository;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired 
	private OrderRepository repository;
	
	@GetMapping()
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = repository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable(value = "id") Long id) {
		Optional<Order> obj = repository.findById(id);
		return ResponseEntity.ok().body(obj.get());
	}
}
