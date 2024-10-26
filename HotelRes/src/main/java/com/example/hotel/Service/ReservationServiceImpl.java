package com.example.hotel.Service;

import java.util.List;

import com.example.hotel.Entity.Reservation;
import com.example.hotel.Repository.ReservationRepository;
import com.example.hotel.Service.Interface.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation saveReservation(Reservation reservationRequest) {
        // Get reservationId as String
        String reservationIdString = reservationRequest.getReservationId(); // Assuming this returns a String

        // Convert String to Long and check if reservation exists
        try {
            Long reservationId = Long.parseLong(reservationIdString); // Convert String to Long
            Reservation existingReservation = reservationRepository.findByReservationId(reservationId);
            if (existingReservation != null) {
                throw new RuntimeException("Reservation already exists..!!");
            }
        } catch (NumberFormatException e) {
            // Handle invalid format for reservation ID
            System.out.println("Invalid reservation ID format: " + reservationIdString);
            throw new RuntimeException("Invalid reservation ID format: " + reservationIdString);
        }

        // Save the new reservation
        return reservationRepository.save(reservationRequest);
    }

    @Override
    public Reservation getReservationById(Long reservationId) {
        return reservationRepository.findByReservationId(reservationId);
    }

    @Override
    public List<Reservation> getReservationByUserId(Long userId) {
        return reservationRepository.findByUserId(userId);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        // Check if reservation exists
        Reservation existingReservation = reservationRepository.findByReservationId(reservation.getReservationId());
        if (existingReservation == null) {
            throw new RuntimeException("Reservation not found..!!");
        }
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}