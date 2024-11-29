package com.reservas.infrastructure.client.payload;

import java.time.Instant;

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
public class FlightDto {

	private Long id;
	private String company;
	private Instant date;
	private double price;
	private int chairs;
}