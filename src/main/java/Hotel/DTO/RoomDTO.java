package Hotel.DTO;


import Hotel.Entity.Room;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RoomDTO {

    int id;
    int hotelId;
    int number;
    double price;


    public RoomDTO(int id, int hotelId, int number, double price) {
        this.id = id;
        this.hotelId = hotelId;
        this.number = number;
        this.price = price;
    }

    public RoomDTO(Room room) {
    }
}
