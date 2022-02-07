package com.praktycznajava.activemqtestclient;

import org.springframework.stereotype.Service;

@Service
public interface BookingService {
    Booking bookHotel(String address);
}
