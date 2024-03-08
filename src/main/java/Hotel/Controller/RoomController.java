package Hotel.Controller;

import Hotel.DAO.RoomDAO;
import Hotel.DTO.RoomDTO;
import Hotel.Entity.Room;
import io.javalin.http.Context;

import java.util.List;
import java.util.stream.Collectors;

public class RoomController {
    private final RoomDAO roomDAO;

    public RoomController(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    public void getAllRooms(Context ctx) {
        List<Room> rooms = roomDAO.getAll();
        List<RoomDTO> roomDTOs = rooms.stream()
                .map(RoomDTO::new)
                .collect(Collectors.toList());
        ctx.json(roomDTOs);
    }

    public void getRoomById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Room room = roomDAO.getById(id);
        if (room != null) {
            RoomDTO roomDTO = new RoomDTO();
            ctx.json(roomDTO);
        } else {
            ctx.status(404).result("Room not found");
        }
    }

    public void createRoom(Context ctx) {
        RoomDTO roomDTO = ctx.bodyAsClass(RoomDTO.class);
        Room newRoom = new Room();
        roomDAO.create(newRoom);
        ctx.json(new RoomDTO());
    }

    public void updateRoom(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        RoomDTO roomDTO = ctx.bodyAsClass(RoomDTO.class);
        Room room = roomDAO.getById(id);
        if (room != null) {
            room.setHotelId(roomDTO.getHotelId());
            room.setNumber(roomDTO.getNumber());
            room.setPrice(roomDTO.getPrice());
            roomDAO.update(room);
            ctx.json(new RoomDTO());
        } else {
            ctx.status(404).result("Room not found");
        }
    }

    public void deleteRoom(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Room room = roomDAO.getById(id);
        if (room != null) {
            roomDAO.delete(id);
            ctx.json(new RoomDTO());
        } else {
            ctx.status(404).result("Room not found");
        }
    }
}
