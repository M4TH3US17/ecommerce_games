package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Client;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.services.exceptions.DatabaseException;
import com.example.demo.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll(){
		return repository.findAll();
	}
	
	public Client findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Client insert(Client obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
		    	repository.deleteById(id);
		} catch(DataIntegrityViolationException e) {
				throw new DatabaseException(e.getMessage());
		} catch(EmptyResultDataAccessException e2) {
				throw new ResourceNotFoundException(id);
		}
	}
	
	public Client update(Long id, Client obj) {
		Client entity = repository.getById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Client entity, Client obj) {
		entity.setName(obj.getName());
		entity.setContact(obj.getContact());
		if(entity.getAddress() == null){
			entity.setAddress(obj.getAddress());
		} else {
			entity.getAddress().setStreet(obj.getAddress().getStreet());
			entity.getAddress().setNumberHouse(obj.getAddress().getNumberHouse());
		}
	}
	
}
