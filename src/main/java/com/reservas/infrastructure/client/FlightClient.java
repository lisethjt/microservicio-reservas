package com.reservas.infrastructure.client;

import com.reservas.infrastructure.client.payload.FlightResponse;

public interface FlightClient {

	public FlightResponse updateFlight(Long flightId);
}