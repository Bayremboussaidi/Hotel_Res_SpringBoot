package com.example.hotel.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.example.hotel.Dto.RoomSearchDTO;
import com.example.hotel.Entity.Room;
import com.example.hotel.Service.Interface.RoomService;


@CrossOrigin
@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    private static final int PAGE_SIZE = 5;


    @PostMapping
    public ResponseEntity<Room> saveRoom(@RequestBody Room room) {
        try {
            Room roomResponse = roomService.saveRoom(room);
            return ResponseEntity.ok(roomResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping
    public ResponseEntity<Room> updateRoom(@RequestBody Room room) {
        try {
            Room roomResponse = roomService.updateRoom(room);
            return ResponseEntity.ok(roomResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping
    public ResponseEntity<String> deleteRoom(@RequestParam Long id) {
        try {
            roomService.deleteRoom(id);
            return ResponseEntity.ok("Room deleted successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Room>> getRoomById(@PathVariable Long id) {
        try {
            Optional<Room> roomResponse = roomService.getRoomById(id);
            return ResponseEntity.ok(roomResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping({"/", ""})
    public ResponseEntity<List<Room>> getAllRooms() {
        try {
            List<Room> roomResponses = roomService.getAllRooms();
            return ResponseEntity.ok(roomResponses);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping({"/type/{roomType}/{page}"})
    public ResponseEntity<List<Room>> getRoomsByType(@PathVariable String roomType, @PathVariable int page) {
        try {
            Page<Room> roomResponses = roomService.getRoomsByType(roomType, page, PAGE_SIZE);
            return ResponseEntity.ok(roomResponses.getContent());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/search")
    public ResponseEntity<List<Room>> findAvailableRoomsForHoliday(@RequestBody RoomSearchDTO roomSearchDTO) {
        try {
            List<Room> roomResponses = roomService.findAvailableRoomsForHoliday(roomSearchDTO);
            return ResponseEntity.ok(roomResponses);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
