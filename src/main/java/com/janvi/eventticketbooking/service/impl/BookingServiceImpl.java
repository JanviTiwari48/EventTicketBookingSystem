package com.janvi.eventticketbooking.service.impl;


import com.janvi.eventticketbooking.dto.BookingRequest;
import com.janvi.eventticketbooking.entity.Booking;
import com.janvi.eventticketbooking.entity.BookingStatus;
import com.janvi.eventticketbooking.entity.Event;
import com.janvi.eventticketbooking.entity.User;
import com.janvi.eventticketbooking.exception.ResourceNotFoundException;
import com.janvi.eventticketbooking.repository.BookingRepository;
import com.janvi.eventticketbooking.repository.EventRepository;
import com.janvi.eventticketbooking.repository.UserRepository;
import com.janvi.eventticketbooking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public Booking createBooking(BookingRequest request){
        User user=userRepository.findById(request.getUserId())
                .orElseThrow(()->new ResourceNotFoundException("User not found with id: "+ request.getUserId()));

        Event event = eventRepository.findById(request.getEventId())
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + request.getEventId()));

        Booking booking = Booking.builder()
                .user(user)
                .event(event)
                .seatCount(request.getSeatCount())
                .bookingDate(LocalDateTime.now())
                .bookingStatus(BookingStatus.CONFIRMED)
                .totalAmount(event.getPrice() * request.getSeatCount())
                .build();

        return bookingRepository.save(booking);
    }
    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
    }

    @Override
    public void deleteBooking(Long id) {
        Booking booking = getBookingById(id);
        bookingRepository.delete(booking);
    }

}
