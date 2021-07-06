package bookstore.repository;

import bookstore.domain.entitites.Book;
import bookstore.domain.entitites.User;

import javax.persistence.EntityManager;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class BookRepository extends JpaRepository<Book> implements GenericRepository<Book> {

    public BookRepository(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Book create(Book book) {
        book.setLastUpdateTime(new Date());
        return super.create(book);
    }

    @Override
    public Book update(Book book) {
        book.setLastUpdateTime(new Date());
        return super.update(book);
    }

    @Override
    public Book get(Object bookId) {
        return super.get(Book.class, bookId);
    }

    @Override
    public void delete(Object id) {
        super.delete(Book.class, id);
    }

    public List<Book> findAllBooksByCategory(int categoryId){
       return super.findWithNamedQuery("Book.findByCategory", "categoryId", categoryId);
    }

    public Book findByBookTitle(String title) {
        List<Book> listBooks = super.findWithNamedQuery("Book.findByTitle", "title", title);
        if (listBooks != null && listBooks.size() > 0) {
            return listBooks.get(0);
        }
        return null;
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
