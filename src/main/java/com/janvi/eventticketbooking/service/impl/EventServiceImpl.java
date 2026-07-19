package com.janvi.eventticketbooking.service.impl;


import com.janvi.eventticketbooking.entity.Event;
import com.janvi.eventticketbooking.repository.EventRepository;
import com.janvi.eventticketbooking.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {


    private final EventRepository eventRepository;

    @Override
    public Event createEvent(Event event) {
        // availableSeats starts equal to totalSeats when an event is first created
        event.setAvailableSeats(event.getTotalSeats());
        return eventRepository.save(event);
    }
    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with id: " + id));
    }
    @Override
    public Event updateEvent(Long id, Event updatedEvent) {
        Event existingEvent = getEventById(id);
        existingEvent.setTitle(updatedEvent.getTitle());
        existingEvent.setDescription(updatedEvent.getDescription());
        existingEvent.setCategory(updatedEvent.getCategory());
        existingEvent.setLocation(updatedEvent.getLocation());
        existingEvent.setDate(updatedEvent.getDate());
        existingEvent.setTime(updatedEvent.getTime());
        existingEvent.setPrice(updatedEvent.getPrice());
        existingEvent.setTotalSeats(updatedEvent.getTotalSeats());
        // note: availableSeats is intentionally NOT overwritten here directly —
        // it's managed by booking/cancellation logic, not manual edits
        return eventRepository.save(existingEvent);
    }

    @Override
    public void deleteEvent(Long id) {
        Event event = getEventById(id);
        eventRepository.delete(event);
    }
}


