package com.reservas.infrastructure.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reservas.application.outport.BookingRepository;
import com.reservas.application.usercase.BookingUserCase;
import com.reservas.domain.model.Booking;

@Service
public class BookingService implements BookingUserCase {

	private BookingRepository bookingRepository;

	public BookingService(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	@Override
	public List<Booking> getBookingList() {
		return bookingRepository.getBookingAll();
	}

	@Override
	public Booking addBooking(Booking booking) {
		return bookingRepository.addBooking(booking);
	}
}