package com.example.hotel.Service.Interface;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hotel.Entity.Reservation;

@Service
public interface ReservationService {

    public Reservation saveReservation(Reservation reservationRequest);

    public Reservation getReservationById(Long reservationId);

    public List<Reservation> getReservationByUserId(Long userId);

    public Reservation updateReservation(Reservation reservation);

    public void deleteReservation(Long reservationId);

    public List<Reservation> getAllReservations();

}
