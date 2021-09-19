
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
import com.example.demo.repositories.AddressRepository;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.GameRepository;
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
	
	@Override
	public void run(String... args) throws Exception {
		Address objA = new Address(null, "Av. samúma", 517);
		Client obj = new Client(null,"Matheus Dalvino", "(92) 00000-0000", objA);
		addressRepository.save(objA);
		clientRepository.save(obj);
		
		Game g1 = new Game(null, "God of War", "Deus da Guerra, o jogo para mobile", 20.00);
		Game g2 = new Game(null, "Pou", "Alimente seu pou", 5.00);
		Game g3 = new Game(null, "Minimundos", "Crie um mundo virtual com seus amigos", 10.00);
		
		Order order = new Order(null, 30.00, Instant.parse("2021-09-13T17:55:32Z"), 50.00, 30.00, obj);
		order.gameAdd(g1);
		order.gameAdd(g2);
		gameRepository.saveAll(Arrays.asList(g1, g2, g3));
		
		Order order2 = new Order(null, 30.00, Instant.parse("2021-09-13T17:55:32Z"), 50.00, 30.00, obj);
	    order2.gameAdd(g3);
		
		orderRepository.saveAll(Arrays.asList(order, order2));
	}
	
	
}
