package com.reservas.infrastructure.client;

import com.reservas.infrastructure.client.payload.HotelResponse;

public interface HotelClient {

	public HotelResponse getHotel(Long id);
}