package bookstore.service;

import bookstore.domain.entitites.Book;
import bookstore.domain.entitites.Category;
import bookstore.domain.servicemodels.BookServiceModel;
import bookstore.domain.servicemodels.CategoryServiceModel;

import java.util.Date;
import java.util.List;

public interface BookService {

    List<BookServiceModel> findALl();

    void createBook(Category category, String title, String author, String isbn, Date publishDate, byte[] image, double price, String description) throws Exception;

    void delete(int id) throws Exception;

    void updateBook(int id, Category category, String title, String author, String isbn, Date publishDate, byte[] image, double price, String description) throws Exception;

    Book findBookByTitle(String title);

    List<BookServiceModel> findByLastUpdateTime();

    List<BookServiceModel> findByCategoryId(int categoryId);

    Book getById(int id);
}
