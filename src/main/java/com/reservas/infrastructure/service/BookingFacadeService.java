package com.reservas.infrastructure.service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.reservas.application.usercase.BookingUserCase;
import com.reservas.domain.model.Booking;
import com.reservas.infrastructure.client.FlightClient;
import com.reservas.infrastructure.client.payload.FlightResponse;
import com.reservas.infrastructure.mapper.BookingDtoMapper;
import com.reservas.infrastructure.payload.BookingDto;
import com.reservas.infrastructure.payload.BookingListResponse;
import com.reservas.infrastructure.payload.BookingRequest;
import com.reservas.infrastructure.payload.MessageResponse;
import com.reservas.infrastructure.repository.BookingResponse;

@Service
public class BookingFacadeService implements BookingFacade {

	private BookingUserCase bookingService;
	private FlightClient flightService;

	public BookingFacadeService(BookingUserCase bookingService, FlightClient flightService) {
		this.bookingService = bookingService;
		this.flightService = flightService;
	}

	@Override
	public BookingListResponse getBookingList() {
		BookingListResponse bookingResponse = new BookingListResponse();
		MessageResponse messageResponse = new MessageResponse();
		messageResponse.setCode("10");
		messageResponse.setMessage("Exito");
		bookingResponse.setBookingList(bookingService.getBookingList().stream().map(BookingDtoMapper::toBookingDto)
				.collect(Collectors.toList()));
		bookingResponse.setMessage(messageResponse);
		return bookingResponse;
	}

	@Override
	public BookingResponse addBooking(BookingRequest bookingReq) {
		BookingResponse bookingResponse = new BookingResponse();
		MessageResponse messageResponse = new MessageResponse();
		messageResponse.setCode("10");
		messageResponse.setMessage("Exito");
		Booking booking = bookingService.addBooking(BookingDtoMapper.toBooking(bookingReq));
		if (booking == null) {
			messageResponse.setCode("20");
			messageResponse.setMessage("Error");
		}

		BookingDto bookingDto = BookingDtoMapper.toBookingDto(booking);
		FlightResponse flight = this.flightService.updateFlight(booking.getFlightId());
		if (flight.getMessage().getCode().equals("10")) {
			bookingDto.setCompany(flight.getFlight().getCompany());
			bookingDto.setEmail("ljimeneztorres@gmail.com");
		}

		bookingResponse.setBooking(bookingDto);
		bookingResponse.setMessage(messageResponse);

		// todo: kafka
		return bookingResponse;
	}
}