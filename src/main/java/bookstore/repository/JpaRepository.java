package bookstore.repository;

import javax.persistence.*;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JpaRepository<T> {

    private static final EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("book_shop");
    }

    public JpaRepository() {

    }


    public T create(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(entity);
        entityManager.flush();
        entityManager.refresh(entity);

        entityManager.getTransaction().commit();
        entityManager.close();
        return entity;
    }


    public T update(T entity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entity = entityManager.merge(entity);

        entityManager.getTransaction().commit();
        entityManager.close();

        return entity;
    }


    public T get(Class<T> type, Object id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        T entity = entityManager.find(type, id);
        if (entity != null) {
            entityManager.refresh(entity);
        }
        entityManager.close();

        return entity;
    }


    public void delete(Class<T> type, Object id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        T entity = entityManager.find(type, id);
        entityManager.getTransaction().begin();

        Object reference = entityManager.getReference(type, id);
        entityManager.remove(reference);

        entityManager.getTransaction().commit();
        entityManager.close();
    }


    public List<T> listAll(String queryName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);
        List resultList = query.getResultList();
        entityManager.close();
        return resultList;
    }

    public List<T> findWithNamedQuery(String queryName, String paramName, Object paramValue) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);
        query.setParameter(paramName, paramValue);
        List resultList = query.getResultList();

        entityManager.close();
        return resultList;
    }

    public List<T> findWithNamedQuery(String queryName, int firstResult, int maxResult) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createNamedQuery(queryName);
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);

        List resultList = query.getResultList();

        entityManager.close();
        return resultList;
    }


    public List<T> findWithNamedQuery(String queryName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);
        List resultList = query.getResultList();
        entityManager.close();
        return resultList;
    }

    public List<T> findWithNamedQuery(String queryName, Map<String, Object> parameters) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);
        Set<Map.Entry<String, Object>> setParameters = parameters.entrySet();
        for (Map.Entry<String, Object> entry : setParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        List resultList = query.getResultList();
        entityManager.close();
        return resultList;
    }

    public long count(String queryName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery(queryName);
        long singleResult = (long) query.getSingleResult();
        entityManager.close();
        return singleResult;
    }

}

