package Hotel.Converter;

import Hotel.DTO.RoomDTO;
import Hotel.Entity.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomConverter {

    public static RoomDTO toDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(room.getId());
        roomDTO.setHotelId(room.getHotelId());
        roomDTO.setNumber(room.getNumber());
        roomDTO.setPrice(room.getPrice());
        return roomDTO;
    }

    public static Room toEntity(RoomDTO roomDTO) {
        Room room = new Room();
        room.setId(roomDTO.getId());
        room.setHotelId(roomDTO.getHotelId());
        room.setNumber(roomDTO.getNumber());
        room.setPrice(roomDTO.getPrice());
        return room;
    }

    public static List<RoomDTO> toDTOList(List<Room> rooms) {
        List<RoomDTO> roomDTOs = new ArrayList<>();
        for (Room room : rooms) {
            roomDTOs.add(toDTO(room));
        }
        return roomDTOs;
    }

    public static List<Room> toEntityList(List<RoomDTO> roomDTOs) {
        List<Room> rooms = new ArrayList<>();
        for (RoomDTO roomDTO : roomDTOs) {
            rooms.add(toEntity(roomDTO));
        }
        return rooms;
    }
}

