package com.reservas.infrastructure.repository;

import com.reservas.infrastructure.payload.BookingDto;
import com.reservas.infrastructure.payload.MessageResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {

	private BookingDto booking;
	private MessageResponse message;
}
