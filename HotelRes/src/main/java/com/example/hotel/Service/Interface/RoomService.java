package com.example.hotel.Service.Interface;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.example.hotel.Dto.RoomSearchDTO;
import com.example.hotel.Entity.Room;

public interface RoomService {
    Room saveRoom(Room roomRequest);

    Optional<Room> getRoomById(Long id);

    Page<Room> getRoomsByType(String roomType, int pageNumber, int pageSize);

    List<Room> getAllRooms();

    Room updateRoom(Room room);

    void deleteRoom(Long id);

    List<Room> findAvailableRoomsForHoliday(RoomSearchDTO roomSearchDTO);
}
