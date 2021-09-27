
package com.example.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entities.Address;
import com.example.demo.entities.Client;
import com.example.demo.entities.Game;
import com.example.demo.entities.Order;
import com.example.demo.entities.OrderGame;
import com.example.demo.repositories.AddressRepository;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.GameRepository;
import com.example.demo.repositories.OrderGameRepository;
import com.example.demo.repositories.OrderRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private GameRepository gameRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderGameRepository orderGameRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Address objA = new Address(null, "Av. samúma", 517);
		Client obj = new Client(null,"Matheus Dalvino", "(92) 00000-0000", objA);
		addressRepository.save(objA);
		clientRepository.save(obj);
		
		Game g1 = new Game(null, "God of War", "Deus da Guerra, o jogo para mobile", 20.00);
		Game g2 = new Game(null, "Pou", "Alimente seu pou", 5.00);
		Game g3 = new Game(null, "Minimundos", "Crie um mundo virtual com seus amigos", 10.00);
		gameRepository.saveAll(Arrays.asList(g1, g2, g3));
		
		Order o1 = new Order(null, 30.00, Instant.parse("2021-09-13T17:55:32Z"), 50.00, 30.00, obj);
		Order o2 = new Order(null, 30.00, Instant.parse("2021-09-13T17:55:32Z"), 50.00, 30.00, obj);
		orderRepository.saveAll(Arrays.asList(o1, o2));
		
		OrderGame og1 = new OrderGame(o1, g1, 2, g1.getPrice());
		OrderGame og2 = new OrderGame(o1,g3, 1, g3.getPrice());
		OrderGame og3 = new OrderGame(o2, g1, 1, g1.getPrice());
		OrderGame og4 = new OrderGame(o2, g2, 2, g2.getPrice());
		
		orderGameRepository.saveAll(Arrays.asList(og1, og2, og3, og4));
		orderRepository.saveAll(Arrays.asList(o1, o2));
		
	}
	
	
}
