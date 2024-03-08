package Hotel.DAO;

import Hotel.Entity.Room;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RoomDAO extends AbstractDAO<Room> {


    private EntityManager entityManager;

    @Override
    protected Class<Room> getEntityClass() {
        return Room.class;
    }

    @Override
    public List<Room> getAll() {
        return entityManager.createQuery("SELECT r FROM Room r", Room.class).getResultList();
    }

    @Override
    public Room getById(int id) {
        return entityManager.find(Room.class, id);
    }

    @Override
    public Room create(Room room) {
        entityManager.persist(room);
        return room;
    }

    @Override
    public Room update(Room room) {
        return entityManager.merge(room);
    }

    @Override
    public void delete(int id) {
        Room room = getById(id);
        if (room != null) {
            entityManager.remove(room);
        }
    }
}
