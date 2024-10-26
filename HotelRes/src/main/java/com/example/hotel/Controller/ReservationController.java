package com.example.hotel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.Entity.Reservation;
import com.example.hotel.Service.Interface.ReservationService;

@CrossOrigin
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation) {
        try {
            Reservation reservationResponse = reservationService.saveReservation(reservation);
            return ResponseEntity.ok(reservationResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {
        try {
            Reservation reservationResponse = reservationService.updateReservation(reservation);
            return ResponseEntity.ok(reservationResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteReservation(@RequestBody Long reservationId) {
        try {
            reservationService.deleteReservation(reservationId);
            return ResponseEntity.ok("Reservation deleted successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        try {
            Reservation reservationResponse = reservationService.getReservationById(id);
            return ResponseEntity.ok(reservationResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping({"/", ""})
    public ResponseEntity<List<Reservation>> getAllReservations() {
        try {
            List<Reservation> reservationResponse = reservationService.getAllReservations();
            return ResponseEntity.ok(reservationResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/user/")
    public ResponseEntity<List<Reservation>> getReservationByUserId(@RequestParam Long userId) {
        try {
            List<Reservation> reservationResponse = reservationService.getReservationByUserId(userId);
            return ResponseEntity.ok(reservationResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
