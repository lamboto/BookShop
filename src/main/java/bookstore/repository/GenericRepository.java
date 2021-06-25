package bookstore.repository;

import java.util.List;

public interface GenericRepository<T> {

    T create(T entity);

    T update(T entity);

    T get(Object id);

    void delete(Object id);

    List<T> listAll();

    long count();
}
