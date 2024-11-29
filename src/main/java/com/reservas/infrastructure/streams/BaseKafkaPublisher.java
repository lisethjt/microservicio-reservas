package com.reservas.infrastructure.streams;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import com.reservas.infrastructure.exception.ErrorMessageException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseKafkaPublisher<T> {
//
//	private final String topic;
//
//	private final KafkaTemplate<String, T> kafkaTemplate;
//
//	public BaseKafkaPublisher(String eventTopic, KafkaTemplate<String, T> kafkaTemplate) {
//		this.topic = eventTopic;
//		this.kafkaTemplate = kafkaTemplate;
//	}
//
//	protected void sendMessageAsync(Object key, T event) {
//		if ((key != null) && (event != null)) {
//			CompletableFuture<SendResult<String, T>> future = kafkaTemplate.send(topic, String.valueOf(key), event);
//			printLogs(future);
//			return;
//		}
//
//		throw new ErrorMessageException(HttpStatus.INTERNAL_SERVER_ERROR, "Key and Evente must");
//	}
//
//	protected void sendMessageSync(Object key, T event) {
//		try {
//			if ((key != null) && (event != null)) {
//				SendResult<String, T> result = kafkaTemplate.send(topic, String.valueOf(key), event).get();
//				printMetaData(result);
//			}
//		} catch (Exception e) {
//			throw new ErrorMessageException(HttpStatus.INTERNAL_SERVER_ERROR, "Key and Evente must");
//		}
//	}
//
//	private void printMetaData(SendResult<String, T> result) {
//		log.info(String.format("topic: %s", result.getRecordMetadata()));
//		log.info(String.format("partition: %s", result.getRecordMetadata()));
//		log.info(String.format("offset: %s", result.getRecordMetadata()));
//	}
//
//	private void printLogs(CompletableFuture<SendResult<String, T>> future) {
//		future.whenComplete((result, exception) -> {
//			if (exception != null) {
//				log.error("Error during the publishing process");
//			} else {
//				log.info("The message was published successfull");
//				printMetaData(result);
//			}
//		});
//
//		log.info("********** publish process was executed **** ");
//	}
}