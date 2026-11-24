package com.data.jpa.bus.config;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.data.jpa.bus.model.Bus;
import com.data.jpa.bus.model.BusType;
import com.data.jpa.bus.repository.BusRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BusDataInitialization implements ApplicationRunner {

	private final BusRepository busRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		if (busRepository.count() == 0) {
			List<Bus> buses = List.of(

					createBus("TS09PS7954", "Hyderabad", "Chennai", new BigDecimal("1400.00"), BusType.AC_SEMISLEEPER),

					createBus("TS09PS7955", "Hyderabad", "Chennai", new BigDecimal("900.00"), BusType.SLEEPER),
					createBus("TS09PS7956", "Hyderabad", "Chennai", new BigDecimal("1100.00"), BusType.AC),
					createBus("TS09PS7957", "Chennai", "Hyderabad", new BigDecimal("800.00"), BusType.SEMI_SLEEPER),
					createBus("TS09PS7958", "Hyderabad", "Chennai", new BigDecimal("1500.00"), BusType.AC),
					createBus("TS09PS7959", "Hyderabad", "Kanyakumari", new BigDecimal("1800.00"),
							BusType.AC_SEMISLEEPER),
					createBus("TS09PS7960", "Hyderabad", "Kanyakumari", new BigDecimal("1100.00"),
							BusType.AC_SEMISLEEPER),
					createBus("TS09PS7961", "Hyderabad", "Jaipur", new BigDecimal("1900.00"), BusType.AC_SLEEPER));

			busRepository.saveAll(buses);

			System.out.println("Sample bus data inserted successfully");
		} else {
			System.out.println("Already the Bus table has records");
		}

	}

	Bus createBus(String busNumber, String source, String destination, BigDecimal ticketPrice, BusType busType) {

		Bus bus = new Bus();
		bus.setBusNumber(busNumber);
		bus.setSource(source);
		bus.setDestination(destination);
		bus.setTicketPrice(ticketPrice);
		bus.setBustType(busType);

		return bus;

	}
}
