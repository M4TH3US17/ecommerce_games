package com.example.demo.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Client;
import com.example.demo.repositories.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientResource {

	@Autowired
	private ClientRepository repository;
	
	@GetMapping()
	public ResponseEntity<List<Client>> findAll(){
		List<Client> list = repository.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id){
		Optional<Client> obj = repository.findById(id);
		return ResponseEntity.ok().body(obj.get());
	}
}
