package com.reservas.infrastructure.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.reservas.application.usercase.BookingUserCase;
import com.reservas.domain.model.Booking;
import com.reservas.infrastructure.client.FlightClient;
import com.reservas.infrastructure.client.HotelClient;
import com.reservas.infrastructure.client.payload.FlightResponse;
import com.reservas.infrastructure.client.payload.HotelResponse;
import com.reservas.infrastructure.mapper.BookingDtoMapper;
import com.reservas.infrastructure.payload.BookingDto;
import com.reservas.infrastructure.payload.BookingEmailDto;
import com.reservas.infrastructure.payload.BookingListResponse;
import com.reservas.infrastructure.payload.BookingRequest;
import com.reservas.infrastructure.payload.MessageResponse;
import com.reservas.infrastructure.repository.BookingResponse;
import com.reservas.infrastructure.streams.Publisher;

@Service
public class BookingFacadeService implements BookingFacade {

	private BookingUserCase bookingService;
	private FlightClient flightService;
	private HotelClient hotelService;
	
	@Qualifier("BookingPublisher")
	private final Publisher<BookingEmailDto> bookingPublisher;

	public BookingFacadeService(BookingUserCase bookingService, FlightClient flightService, HotelClient hotelService,
			Publisher<BookingEmailDto> bookingPublisher) {
		
		this.bookingService = bookingService;
		this.flightService = flightService;
		this.hotelService = hotelService;
		this.bookingPublisher = bookingPublisher;
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
		bookingResponse.setBooking(bookingDto);
		bookingResponse.setMessage(messageResponse);
	
		HotelResponse hotel = this.hotelService.getHotel(booking.getHotelId());
		
		BookingEmailDto bookingEmailDto = BookingDtoMapper.toBookingEmailDto(booking, hotel, flight);
		bookingPublisher.publish(bookingEmailDto);
		return bookingResponse;
	}

	

	
}