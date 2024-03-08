package Hotel.DAO;

import Hotel.Entity.Room;
import Hotel.HibernateConfig;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractDAO <T> implements IDAO<T> {

   private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    private int nextId = 1;

    private EntityManager entityManager;

    @Override
    public List<T> getAll() {
        return entityManager.createQuery("SELECT e FROM " + getEntityClass().getSimpleName() + " e", getEntityClass())
                .getResultList();
    }

    @Override
    public T getById(int id) {
        return entityManager.find(getEntityClass(), id);
    }

    @Override
    public T create(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public T update(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(int id) {
        T entity = getById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    // Abstract method to be implemented by concrete DAO classes
    protected abstract Class<T> getEntityClass();
}