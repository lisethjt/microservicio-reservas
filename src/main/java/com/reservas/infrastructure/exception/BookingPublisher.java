package com.reservas.infrastructure.exception;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.reservas.infrastructure.payload.BookingDto;
import com.reservas.infrastructure.streams.BaseKafkaPublisher;
import com.reservas.infrastructure.streams.Publisher;
import com.reservas.infrastructure.streams.event.BookingEvent;

@Component
@Qualifier("BookingPublisher")
public class BookingPublisher extends BaseKafkaPublisher<BookingEvent> implements Publisher<BookingDto> {

//	public BookingPublisher(@Value("${publisher.topic.contact}") String eventTopic, KafkaTemplate<String, BookingEvent> kafkaTemplate) {
//	//	super(eventTopic, kafkaTemplate);		
//	}

	@Override
	public void publish(BookingDto source) {
//		BookingEvent.builder()
//		           .name(source.getName())		           
//		           .hotel(source.getHotel())
//		           .flightId(source.getFlightId())
//		           .company(source.getCompany())
//		           .bookingId(source.getBookingId())
//		           .email(source.getEmail())
//		           .date(source.getDate())
//		           .build(); 		
	}
}