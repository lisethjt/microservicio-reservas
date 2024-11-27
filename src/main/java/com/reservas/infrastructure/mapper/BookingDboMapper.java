package com.reservas.infrastructure.mapper;

import com.reservas.domain.model.Booking;
import com.reservas.infrastructure.entities.BookingEntity;

public final class BookingDboMapper {

	public static Booking toBooking(BookingEntity booking) {
		return Booking.builder()
				.id(booking.getId())
				.name(booking.getName())
				.dni(booking.getDni())
				.hotelId(booking.getIdHotel())
				.flightId(booking.getIdVuelo())
				.date(booking.getDate())
				.build();
	}
	
	public static BookingEntity toBookingEntity(Booking booking) {
		return BookingEntity.builder()
				.id(booking.getId())
				.name(booking.getName())
				.dni(booking.getDni())
				.idHotel(booking.getHotelId())
				.idVuelo(booking.getFlightId())
				.date(booking.getDate())
				.build();
	}
}