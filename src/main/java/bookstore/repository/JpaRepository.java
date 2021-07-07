package bookstore.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JpaRepository<T> {


    protected EntityManager entityManager;

    public JpaRepository(EntityManager entityManager) {

        this.entityManager = entityManager;
    }


    public T create(T entity) {
        this.entityManager.getTransaction().begin();

        this.entityManager.persist(entity);
        this.entityManager.flush();
        this.entityManager.refresh(entity);
        this.entityManager.getTransaction().commit();

        return entity;
    }


    public T update(T entity) {
        this.entityManager.getTransaction().begin();
        entity = this.entityManager.merge(entity);

        this.entityManager.getTransaction().commit();

        return entity;
    }


    public T get(Class<T> type, Object id) {
        return this.entityManager.find(type, id);
    }


    public void delete(Class<T> type, Object id) {
        entityManager.getTransaction().begin();

        Object reference = entityManager.getReference(type, id);
        this.entityManager.remove(reference);
        entityManager.getTransaction().commit();
    }


    public List<T> listAll(String queryName) {
        Query query = this.entityManager.createNamedQuery(queryName);

        return query.getResultList();
    }

    public List<T> findWithNamedQuery(String queryName, String paramName, Object paramValue) {
        Query query = entityManager.createNamedQuery(queryName);
        query.setParameter(paramName, paramValue);
        return query.getResultList();
    }
    public List<T> findWithNamedQuery(String queryName) {
        Query query = entityManager.createNamedQuery(queryName);
        return query.getResultList();
    }
    public List<T> findWithNamedQuery(String queryName, Map<String, Object> parameters) {
        Query query = entityManager.createNamedQuery(queryName);
        Set<Map.Entry<String, Object>> setParameters = parameters.entrySet();
        for (Map.Entry<String, Object> entry : setParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        return query.getResultList();
    }

    public long count(String queryName) {
        Query query = this.entityManager.createNamedQuery(queryName);

        return (long) query.getSingleResult();
    }

}

