package Hotel.Entity;


import Hotel.Entity.Hotel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "room")
@Entity
@ToString
public class Room {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
    int id;
    @Column(name = "hotel_id")
    int hotelId;
    @Column(name = "number")
    int number;
    @Column(name = "price")
    double price;
 //   @ManyToOne
   // Hotel hotel;

    public Room(int id, int hotelId, int number, double price) {
        this.id = id;
        this.hotelId = hotelId;
        this.number = number;
        this.price = price;
    }
}
