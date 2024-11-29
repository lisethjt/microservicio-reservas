package com.reservas.infrastructure.streams;

public interface Publisher<T> {

	void publish(T source);
}