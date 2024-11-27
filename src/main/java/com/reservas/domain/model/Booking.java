package com.reservas.domain.model;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
	
	private Long id;
	private String dni;
	private String name;
	private Long hotelId;
	private Long flightId;
	private Instant date;
	
}