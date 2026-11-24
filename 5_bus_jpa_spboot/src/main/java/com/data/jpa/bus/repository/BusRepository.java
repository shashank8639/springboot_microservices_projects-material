package com.data.jpa.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.data.jpa.bus.model.Bus;

public interface BusRepository extends JpaRepository<Bus, Long> {

	
}
