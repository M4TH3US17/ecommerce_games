package com.example.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Address;
import com.example.demo.entities.Client;

@RestController
@RequestMapping(value = "/client")
public class ClientResource {

	@GetMapping
	public ResponseEntity<Client> findAll(){
		Client obj = new Client(null, "Matheus Dalvino", "(92) 00000-0000", 
				new Address(null, "av. samaúma", 517));
		return ResponseEntity.ok().body(obj);
	}
}
