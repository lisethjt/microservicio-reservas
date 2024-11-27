package com.reservas.application.outport;

import java.util.List;

import com.reservas.domain.model.Booking;

public interface BookingRepository {

	public List<Booking> getBookingAll();

	public Booking addBooking(Booking booking);
}