package com.reservas.infrastructure.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlightClientService implements FlightClient {

	@Autowired
	RestTemplate template;
	String resourceUrl = "http://localhost:9000/flight/";
	
	@Override
	public void updateFlight(Long flightId) {		
		template.exchange(resourceUrl+ "updateFlight/" + flightId, HttpMethod.PUT, null, Void.class);
	}
}