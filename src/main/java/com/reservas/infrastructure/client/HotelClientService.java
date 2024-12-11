package com.reservas.infrastructure.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.reservas.infrastructure.client.payload.HotelResponse;

@Service
public class HotelClientService implements HotelClient {

	@Autowired
	RestTemplate template;
	String resourceUrl = "http://microservicio-hoteles/hotels/";
	
	@Override
	public HotelResponse getHotel(Long id) {
		ResponseEntity<HotelResponse> response = template.exchange(resourceUrl + id, HttpMethod.GET,
				null, HotelResponse.class);		
		return response.getBody();
	}
}