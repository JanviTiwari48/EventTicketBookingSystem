package com.janvi.eventticketbooking.repository;

import com.janvi.eventticketbooking.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
