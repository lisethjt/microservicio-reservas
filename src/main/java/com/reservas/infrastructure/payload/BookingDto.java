package com.reservas.infrastructure.payload;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {

	private Long id;
	private String dni;
	private String name;	
	private Instant date;	
	private Long hotelId;
	private Long flightId;
}