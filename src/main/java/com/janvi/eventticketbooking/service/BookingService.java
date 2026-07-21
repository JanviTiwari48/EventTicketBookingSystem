package com.janvi.eventticketbooking.service;

import com.janvi.eventticketbooking.dto.BookingRequest;
import com.janvi.eventticketbooking.entity.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(BookingRequest request);
    List<Booking> getAllBookings();
    Booking getBookingById(Long id);
    void deleteBooking(Long id);
}
