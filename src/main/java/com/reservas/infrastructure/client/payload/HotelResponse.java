package com.reservas.infrastructure.client.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelResponse {

	private Long id;
	private String name;
	private String category;
	private double price;
	private String available;
	private String image;
}