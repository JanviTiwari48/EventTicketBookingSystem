package com.janvi.eventticketbooking.controller;


import com.janvi.eventticketbooking.dto.BookingRequest;
import com.janvi.eventticketbooking.entity.Booking;
import com.janvi.eventticketbooking.service.BookingService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
   public ResponseEntity<Booking>createBooking( @Valid  @RequestBody BookingRequest request){
        Booking created=bookingService.createBooking(request);
        return new ResponseEntity<>(created, HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok("Booking deleted successfully");
    }
}
