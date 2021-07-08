package bookstore.service.impl;

import bookstore.domain.entitites.Book;
import bookstore.domain.entitites.Category;
import bookstore.domain.servicemodels.BookServiceModel;
import bookstore.domain.servicemodels.CategoryServiceModel;
import bookstore.repository.BookRepository;
import bookstore.service.BookService;
import config.Mapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final Mapper mapper = new Mapper();
    private final ValidationServiceImpl userValidationService = new ValidationServiceImpl();

    public BookServiceImpl() {
        this.bookRepository = new BookRepository();
    }

    @Override
    public List<BookServiceModel> findALl() {
        return this.bookRepository.listAll().stream()
                .map(e -> this.mapper.map(e, BookServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void createBook(Category category, String title, String author, String isbn, Date publishDate, byte[] image, double price, String description) throws Exception {


        if (userValidationService.canCreateBook(title)) {
            BookServiceModel bookServiceModel = new BookServiceModel();
            bookServiceModel.setCategory(this.mapper.map(category, CategoryServiceModel.class));
            bookServiceModel.setTitle(title);
            bookServiceModel.setAuthor(author);
            bookServiceModel.setIsbn(isbn);
            bookServiceModel.setPublishDate(publishDate);
            bookServiceModel.setImage(image);
            bookServiceModel.setPrice(price);
            bookServiceModel.setDescription(description);
            this.bookRepository.create(mapper.map(bookServiceModel, Book.class));
        } else {
            throw new Exception("Book cannot be created");
        }
    }

    @Override
    public void delete(int id) throws Exception {
        if (this.userValidationService.isBookValidToDelete(id)) {
            this.bookRepository.delete(id);
        } else {
            throw new Exception("Book cannot be deleted");
        }
    }

    @Override
    public void updateBook(int id, Category category, String title, String author, String isbn, Date publishDate, byte[] image, double price, String description) throws Exception {

        BookServiceModel bookServiceModel = new BookServiceModel();

        bookServiceModel.setBookId(id);
        bookServiceModel.setCategory(this.mapper.map(category, CategoryServiceModel.class));
        bookServiceModel.setTitle(title);
        bookServiceModel.setAuthor(author);
        bookServiceModel.setIsbn(isbn);
        bookServiceModel.setPublishDate(publishDate);
        bookServiceModel.setImage(image);
        bookServiceModel.setPrice(price);
        bookServiceModel.setDescription(description);

        this.bookRepository.update(mapper.map(bookServiceModel, Book.class));
    }

    @Override
    public Book findBookByTitle(String title) {
        return this.bookRepository.findByBookTitle(title);
    }

    @Override
    public List<BookServiceModel> findByLastUpdateTime() {
        return this.bookRepository.listNewestBooks().stream()
                .map(e -> this.mapper.map(e, BookServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookServiceModel> findByKeyword(String keyword) {
        return this.bookRepository.findByKeyword(keyword).stream()
                .map(e -> this.mapper.map(e, BookServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookServiceModel> findByCategoryId(int categoryId) {
        return this.bookRepository.findAllBooksByCategory(categoryId).stream()
                .map(e -> this.mapper.map(e, BookServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public Book getById(int id) {
        return this.bookRepository.get(id);
    }

    public byte[] getBytes(Part part) throws IOException {
        byte[] imageBytes = null;
        if (part != null && part.getSize() > 0) {
            long size = part.getSize();
            imageBytes = new byte[(int) size];

            InputStream inputStream = part.getInputStream();
            inputStream.read(imageBytes);
            inputStream.close();
        }
        return imageBytes;
    }
}

