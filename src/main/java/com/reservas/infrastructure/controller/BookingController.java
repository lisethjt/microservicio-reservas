package com.reservas.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservas.infrastructure.payload.BookingListResponse;
import com.reservas.infrastructure.payload.BookingRequest;
import com.reservas.infrastructure.repository.BookingResponse;
import com.reservas.infrastructure.service.BookingFacade;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "booking")
public class BookingController {

	private BookingFacade bookingFacade;

	public BookingController(BookingFacade bookingFacade) {
		this.bookingFacade = bookingFacade;
	}

	@GetMapping(value = "/getBookingList")
	ResponseEntity<BookingListResponse> getBookingList() {
		return new ResponseEntity<>(bookingFacade.getBookingList(), HttpStatus.OK);
	}

	@PostMapping(value = "/addBooking")
	public ResponseEntity<BookingResponse> addBooking(@RequestBody BookingRequest booking) {
		return new ResponseEntity<>(bookingFacade.addBooking(booking), HttpStatus.OK);
	}
}