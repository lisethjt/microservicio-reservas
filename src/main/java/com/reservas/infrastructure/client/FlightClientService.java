package com.reservas.infrastructure.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.reservas.infrastructure.client.payload.FlightResponse;

@Service
public class FlightClientService implements FlightClient {

	@Autowired
	RestTemplate template;
	String resourceUrl = "http://microservicio-vuelos/flight/";

	@Override
	public FlightResponse updateFlight(Long flightId) {
		ResponseEntity<FlightResponse> response = template.exchange(resourceUrl + "updateFlight/" + flightId, HttpMethod.PUT,
				null, FlightResponse.class);		
		return response.getBody();
	}
}