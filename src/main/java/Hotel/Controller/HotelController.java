package Hotel.Controller;

import Hotel.DAO.HotelDAO;
import Hotel.DTO.HotelDTO;
import Hotel.DTO.RoomDTO;
import Hotel.Entity.Hotel;
import Hotel.Entity.Room;
import io.javalin.http.Context;

import java.util.List;
import java.util.stream.Collectors;

public class HotelController {
    private final HotelDAO hotelDAO;

    public HotelController(HotelDAO hotelDAO) {
        this.hotelDAO = hotelDAO;
    }

    public void getAllHotels(Context ctx) {
        List<Hotel> hotels = hotelDAO.getAll();
        List<HotelDTO> hotelDTOs = hotels.stream()
                .map(HotelDTO::new)
                .collect(Collectors.toList());
        ctx.json(hotelDTOs);
    }

    public void getHotelById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Hotel hotel = hotelDAO.getById(id);
        if (hotel != null) {
            HotelDTO hotelDTO = new HotelDTO();
            ctx.json(hotelDTO);
        } else {
            ctx.status(404).result("Hotel not found");
        }
    }

    public void getRoomsForHotel(Context ctx) {
        int hotelId = Integer.parseInt(ctx.pathParam("id"));
        List<Room> rooms = hotelDAO.getRoomsForHotel(hotelId);
        List<RoomDTO> roomDTOs = rooms.stream()
                .map(RoomDTO::new)
                .collect(Collectors.toList());
        ctx.json(roomDTOs);
    }

    public void createHotel(Context ctx) {
        HotelDTO hotelDTO = ctx.bodyAsClass(HotelDTO.class);
        Hotel newHotel = new Hotel();
        hotelDAO.create(newHotel);
        ctx.json(new HotelDTO(newHotel));
    }

    public void updateHotel(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        HotelDTO hotelDTO = ctx.bodyAsClass(HotelDTO.class);
        Hotel hotel = hotelDAO.getById(id);
        if (hotel != null) {
            hotel.setName(hotelDTO.getName());
            hotel.setAddress(hotelDTO.getAddress());
            hotelDAO.update(hotel);
            ctx.json(new HotelDTO());
        } else {
            ctx.status(404).result("Hotel not found");
        }
    }

    public void deleteHotel(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Hotel hotel = hotelDAO.getById(id);
        if (hotel != null) {
            hotelDAO.delete(id);
            ctx.json(new HotelDTO());
        } else {
            ctx.status(404).result("Hotel not found");
        }
    }

}
