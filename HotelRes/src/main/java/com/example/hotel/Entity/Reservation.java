package com.example.hotel.Entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "reservations") // Specify the MongoDB collection name
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    private String reservationId; // Change to String for MongoDB ObjectId

    private Date reservationDate;
    private Date checkInDate;
    private Date checkOutDate;

    //IDeref(lazy = true) // Use DBRef for referencing another document (Room)
    private Room room;

    @DBRef(lazy = true) // Use DBRef for referencing another document (UserInfo)
    private UserInfo user;

    private String reservationStatus;
    private String reservationType;

    private float reservationPrice;
    private String reservationPaymentMethod;
    private String reservationPaymentStatus;
    private Date reservationPaymentDate;
}