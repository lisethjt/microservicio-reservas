package com.reservas.infrastructure.payload;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingListResponse {

	private List<BookingDto> bookingList;
	private MessageResponse message;
}