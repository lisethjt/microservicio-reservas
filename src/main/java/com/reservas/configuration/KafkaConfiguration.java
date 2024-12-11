package com.reservas.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfiguration {

	public static final String CONFIG_REPLICA = "min.insync.replicas";

	@Value("${publisher.topic.booking}")
	private String bookingEvent;

	@Bean
	public NewTopic createBookingTopic() {
		return TopicBuilder.name(bookingEvent)
				.partitions(3)
				//.replicas(0)
				//.configs(Map.of(CONFIG_REPLICA, "2"))
				.build();
	}
}