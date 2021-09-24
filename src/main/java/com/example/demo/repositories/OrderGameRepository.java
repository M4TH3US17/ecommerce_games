package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.OrderGame;

public interface OrderGameRepository extends JpaRepository<OrderGame, Long>{

}
