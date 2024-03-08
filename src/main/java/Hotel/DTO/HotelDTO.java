package Hotel.DTO;

import Hotel.Entity.Hotel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class HotelDTO {

    int id;
    String name;
    String address;
     List<RoomDTO> rooms;

    public HotelDTO(int id, String name, String address, List<RoomDTO> rooms) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rooms = rooms;
    }

    public HotelDTO(Hotel hotel) {
    }
}
