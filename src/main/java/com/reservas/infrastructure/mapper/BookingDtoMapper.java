package com.reservas.infrastructure.mapper;

import java.time.Instant;

import com.reservas.domain.model.Booking;
import com.reservas.infrastructure.client.payload.FlightResponse;
import com.reservas.infrastructure.client.payload.HotelResponse;
import com.reservas.infrastructure.payload.BookingDto;
import com.reservas.infrastructure.payload.BookingEmailDto;
import com.reservas.infrastructure.payload.BookingRequest;

public final class BookingDtoMapper {

	public static BookingDto toBookingDto(Booking booking) {
		return BookingDto.builder()				
				.name(booking.getName())
				.dni(booking.getDni())	
				.date(booking.getDate())
				.id(booking.getId())
				.hotelId(booking.getHotelId())
				.flightId(booking.getFlightId())
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
	
	public static BookingEmailDto toBookingEmailDto(Booking booking, HotelResponse hotel, FlightResponse flight) {
		return BookingEmailDto.builder()				
				.name(booking.getName())
				.hotel(hotel.getName())
				.flightId(booking.getFlightId())
				.company(flight.getFlight().getCompany())
				.bookingId(booking.getId())
				.date(booking.getDate())	
				.email("ljimeneztorres@gmail.com")
				.build();
	}
}