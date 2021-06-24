package bookstore.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class JpaRepository<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> persistentClass;

    public JpaRepository(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }


    public JpaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public T create(T t) {
        this.entityManager.getTransaction().begin();

        this.entityManager.persist(t);
        this.entityManager.flush();

        this.entityManager.getTransaction().commit();

        return t;
    }

    public T update(T t) {
        this.entityManager.getTransaction().begin();

        this.entityManager.merge(t);

        this.entityManager.getTransaction().commit();

        return t;
    }

    public T get(Integer id) {
        return this.entityManager.find(persistentClass, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> listAll() {
        return this.entityManager.createQuery("select  t from" + persistentClass.getSimpleName() + " t")
                .getResultList();
    }
}
