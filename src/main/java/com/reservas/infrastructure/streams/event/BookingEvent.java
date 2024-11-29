package com.reservas.infrastructure.streams.event;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BookingEvent {

	private String name;
	private String hotel;
	private Long flightId;
	private String company;
	private String bookingId;
	private Instant date;
	private String email;
}