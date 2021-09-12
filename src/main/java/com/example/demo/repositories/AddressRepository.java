package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
