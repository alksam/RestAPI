package Hotel.Converter;

import Hotel.DTO.HotelDTO;
import Hotel.Entity.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelConverter {

    public static HotelDTO toDTO(Hotel hotel) {
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setId(hotel.getId());
        hotelDTO.setName(hotel.getName());
        hotelDTO.setAddress(hotel.getAddress());
        // You might need to convert the list of rooms as well
        // hotelDTO.setRooms(RoomConverter.toDTOList(hotel.getRooms()));
        return hotelDTO;
    }

    public static Hotel toEntity(HotelDTO hotelDTO) {
        Hotel hotel = new Hotel();
        hotel.setId(hotelDTO.getId());
        hotel.setName(hotelDTO.getName());
        hotel.setAddress(hotelDTO.getAddress());
        // You might need to convert the list of roomDTOs as well
        // hotel.setRooms(RoomConverter.toEntityList(hotelDTO.getRooms()));
        return hotel;
    }

    public static List<HotelDTO> toDTOList(List<Hotel> hotels) {
        List<HotelDTO> hotelDTOs = new ArrayList<>();
        for (Hotel hotel : hotels) {
            hotelDTOs.add(toDTO(hotel));
        }
        return hotelDTOs;
    }

    public static List<Hotel> toEntityList(List<HotelDTO> hotelDTOs) {
        List<Hotel> hotels = new ArrayList<>();
        for (HotelDTO hotelDTO : hotelDTOs) {
            hotels.add(toEntity(hotelDTO));
        }
        return hotels;
    }

}
