package com.reservas.infrastructure.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {

	private String dni;
	private String name;
	private Long hotelId;
	private Long flightId;	
}