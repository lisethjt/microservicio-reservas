package com.reservas.infrastructure.streams;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.reservas.infrastructure.payload.BookingEmailDto;
import com.reservas.infrastructure.streams.event.BookingEvent;

@Component
@Qualifier("BookingPublisher")
public class BookingPublisher extends BaseKafkaPublisher<BookingEvent> implements Publisher<BookingEmailDto> {

	public BookingPublisher(@Value("${publisher.topic.booking}") String eventTopic,
			KafkaTemplate<String, BookingEvent> kafkaTemplate) {
		super(eventTopic, kafkaTemplate);
	}
	@Override
	public void publish(BookingEmailDto booking) {
		BookingEvent bookingEvent = BookingEvent.builder()		
				.name(booking.getName())
				.hotel(booking.getName())
				.flightId(booking.getFlightId())
				.company(booking.getCompany())
				.bookingId(booking.getBookingId())
				.date(booking.getDate())	
				.email(booking.getEmail())
				.build();
		sendMessageAsync(String.valueOf(booking.getBookingId()), bookingEvent);
	}
}