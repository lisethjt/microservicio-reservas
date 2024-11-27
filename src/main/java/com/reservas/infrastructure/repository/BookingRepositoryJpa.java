package com.reservas.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservas.infrastructure.entities.BookingEntity;

public interface BookingRepositoryJpa extends JpaRepository<BookingEntity, Long>{

}