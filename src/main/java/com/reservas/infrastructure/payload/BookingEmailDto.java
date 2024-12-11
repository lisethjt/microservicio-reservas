package com.reservas.infrastructure.payload;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BookingEmailDto {

	private String name;
	private String hotel;
	private Long flightId;
	private String company;
	private Long bookingId;
	private Instant date;
	private String email;
}