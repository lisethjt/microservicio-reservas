package com.reservas.infrastructure.mapper;

import java.time.Instant;

import com.reservas.domain.model.Booking;
import com.reservas.infrastructure.payload.BookingDto;
import com.reservas.infrastructure.payload.BookingRequest;

public final class BookingDtoMapper {

	public static BookingDto toBookingDto(Booking booking) {
		return BookingDto.builder()				
				.name(booking.getName())
				.dni(booking.getDni())
				.hotelId(booking.getHotelId())
				.flightId(booking.getFlightId())
				.date(booking.getDate())
				.build();
	}	
	
	public static Booking toBooking(BookingRequest booking) {
		return Booking.builder()				
				.name(booking.getName())
				.dni(booking.getDni())
				.hotelId(booking.getHotelId())
				.flightId(booking.getFlightId())
				.date(Instant.now())
				.build();
	}
}