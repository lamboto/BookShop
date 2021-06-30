package bookstore.repository;

import bookstore.domain.entitites.Book;
import bookstore.domain.entitites.User;

import javax.persistence.EntityManager;
import java.util.List;

public class BookRepository extends JpaRepository<Book> implements GenericRepository<Book>{

    public BookRepository(EntityManager entityManager) {
        super(entityManager);
    }
    @Override
    public Book create(Book book) {
        return super.create(book);
    }

    @Override
    public Book update(Book book) {
        return super.update(book);
    }
    @Override
    public Book get(Object bookId) {
        return super.get(Book.class,bookId);
    }

    @Override
    public void delete(Object id) {
        super.delete(Book.class, id);
    }

    @Override
    public List<Book> listAll() {
        return super.listAll("Book.findAll");
    }

    @Override
    public long count() {
        return super.count("Book.count");
    }


}
