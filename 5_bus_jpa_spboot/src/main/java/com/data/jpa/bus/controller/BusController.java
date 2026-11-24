package com.data.jpa.bus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.data.jpa.bus.model.Bus;
import com.data.jpa.bus.service.BusService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/buses")
@AllArgsConstructor
public class BusController {

	private final BusService busService;
	
	@PostMapping
	public Bus saveBus(@RequestBody Bus bus) {

		return busService.save(bus);
	}
	
	@GetMapping
	public List<Bus> getBuses() {

		return busService.getBuses();
	}
	
	@GetMapping("/busId/{id}")
	public Bus getBus(@PathVariable long id) {

		return busService.getBus(id);
	}
	
}
