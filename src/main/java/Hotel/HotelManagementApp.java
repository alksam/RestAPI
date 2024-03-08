package Hotel;


import Hotel.Controller.HotelController;
import Hotel.Controller.RoomController;
import Hotel.DAO.HotelDAO;
import Hotel.DAO.RoomDAO;
import Hotel.Entity.Hotel;
import Hotel.Entity.Room;
import io.javalin.Javalin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

public class HotelManagementApp {

    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7000);

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        List<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel(1, "Hilton", "1234 Hilton Street"));
        hotels.add(new Hotel(2, "Marriott", "5678 Marriott Street"));
        hotels.add(new Hotel(3, "Holiday Inn", "91011 Holiday Inn Street"));
        hotels.add(new Hotel(4, "Sheraton", "121314 Sheraton Street"));
        hotels.add(new Hotel(5, "Hyatt", "151617 Hyatt Street"));
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(1, 1, 101, 100.0));
        rooms.add(new Room(2, 1, 102, 110.0));
        rooms.add(new Room(3, 2, 201, 120.0));
        rooms.add(new Room(4, 2, 202, 130.0));
        rooms.add(new Room(5, 3, 301, 140.0));


        em.persist(hotels);
        em.persist(rooms);

        HotelDAO hotelDAO = new HotelDAO(); // Assuming you have implemented DAOs
        RoomDAO roomDAO = new RoomDAO();    // Assuming you have implemented DAOs
        HotelController hotelController = new HotelController(hotelDAO);
        RoomController roomController = new RoomController(roomDAO);

        // Hotel routes
        app.get("/hotel", hotelController::getAllHotels);
        app.get("/hotel/{id}", hotelController::getHotelById);
        app.get("/hotel/{id}/rooms", hotelController::getRoomsForHotel);
        app.post("/hotel", hotelController::createHotel);
        app.put("/hotel/{id}", hotelController::updateHotel);
        app.delete("/hotel/{id}", hotelController::deleteHotel);

        // Room routes
        app.get("/room", roomController::getAllRooms);
        app.get("/room/{id}", roomController::getRoomById);
        app.post("/room", roomController::createRoom);
        app.put("/room/{id}", roomController::updateRoom);
        app.delete("/room/{id}", roomController::deleteRoom);
    }
}

