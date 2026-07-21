package com.janvi.eventticketbooking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequest {
    private Long userId;
    private Long eventId;
    private int seatCount;
}
