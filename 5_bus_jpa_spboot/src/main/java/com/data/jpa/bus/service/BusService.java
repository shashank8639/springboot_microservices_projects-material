package com.data.jpa.bus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.data.jpa.bus.model.Bus;
import com.data.jpa.bus.repository.BusRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BusService {

	private final BusRepository busRepository;

	public Bus save(Bus bus) {

		return busRepository.save(bus);
	}

	public List<Bus> getBuses() {

		
		return busRepository.findAll();
	}

	public Bus getBus(long id) {

		Optional<Bus> optional = busRepository.findById(id);
		
		if(optional.isPresent())
			return optional.get();
		
		return null;
	}
}