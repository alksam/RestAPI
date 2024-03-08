package Hotel.DAO;

import Hotel.Entity.Hotel;
import Hotel.Entity.Room;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class HotelDAO extends AbstractDAO<Hotel> {




    private EntityManager entityManager;

    @Override
    protected Class<Hotel> getEntityClass() {
        return Hotel.class;
    }

    public List<Room> getRoomsForHotel(int hotelId) {
        // Implement logic to retrieve all rooms for a specific hotel
        return null;
    }

    @Override
    public List<Hotel> getAll() {
        return entityManager.createQuery("SELECT h FROM Hotel h", Hotel.class).getResultList();
    }

    @Override
    public Hotel getById(int id) {
        return entityManager.find(Hotel.class, id);
    }

    @Override
    public Hotel create(Hotel hotel) {
        entityManager.persist(hotel);
        return hotel;
    }

    @Override
    public Hotel update(Hotel hotel) {
        return entityManager.merge(hotel);
    }

    @Override
    public void delete(int id) {
        Hotel hotel = getById(id);
        if (hotel != null) {
            entityManager.remove(hotel);
        }
    }
}