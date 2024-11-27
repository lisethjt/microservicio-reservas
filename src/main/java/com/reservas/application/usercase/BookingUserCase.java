package com.reservas.application.usercase;

import java.util.List;

import com.reservas.domain.model.Booking;

public interface BookingUserCase {

	public List<Booking> getBookingList();
	
	public Booking addBooking(Booking booking);	
}