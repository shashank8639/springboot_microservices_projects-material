package com.data.jpa.bus.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "buses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "bus_number"
			, nullable = false
			, unique = true)
	private String busNumber;
	
	@Column(nullable = false)
	private String source;
	
	@Column(nullable = false)
	private String destination;
	
	@Column(name = "ticket_price", precision = 10, scale=2)
	private BigDecimal ticketPrice;
	
	@Enumerated(EnumType.STRING)
	private BusType bustType;
	
}
