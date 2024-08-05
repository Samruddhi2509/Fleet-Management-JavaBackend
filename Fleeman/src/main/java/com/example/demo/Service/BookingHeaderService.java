package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.BookingHeader;

public interface BookingHeaderService {
    List<BookingHeader> getAllBookings();
    Optional<BookingHeader> getBookingById(Long id);
    BookingHeader createBooking(BookingHeader bookingHeader);
    Optional<BookingHeader> updateBooking(Long id, BookingHeader bookingDetails);
    boolean deleteBooking(Long id);
}
