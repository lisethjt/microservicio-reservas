package com.reservas.infrastructure.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.reservas.application.outport.BookingRepository;
import com.reservas.domain.model.Booking;
import com.reservas.infrastructure.mapper.BookingDboMapper;

@Repository
public class BookingRepositoryImpl implements BookingRepository {

	private BookingRepositoryJpa bookingRepository;
	
	public BookingRepositoryImpl(BookingRepositoryJpa bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	@Override
	public List<Booking> getBookingAll() {
		return bookingRepository.findAll()
				.stream()
				.map(BookingDboMapper::toBooking)
				.collect(Collectors.toList());
	}

	@Override
	public Booking addBooking(Booking booking) {
		return BookingDboMapper.toBooking(bookingRepository.save(BookingDboMapper.toBookingEntity(booking)));
	}
}