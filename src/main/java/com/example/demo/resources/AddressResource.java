package com.example.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Address;

@RestController
@RequestMapping("/address")
public class AddressResource {
	
	@GetMapping
	public ResponseEntity<Address> findAll(){
		Address obj = new Address(null, "av. samaúma", 517);
		return ResponseEntity.ok().body(obj);
	}
}
