package com.reservas.infrastructure.service;

import com.reservas.infrastructure.payload.BookingListResponse;
import com.reservas.infrastructure.payload.BookingRequest;
import com.reservas.infrastructure.repository.BookingResponse;

public interface BookingFacade {

	public BookingListResponse getBookingList();

	public BookingResponse addBooking(BookingRequest booking);
}
