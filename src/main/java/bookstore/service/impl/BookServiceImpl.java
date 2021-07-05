package bookstore.service.impl;

import bookstore.domain.entitites.Book;
import bookstore.domain.entitites.Category;
import bookstore.domain.entitites.User;
import bookstore.domain.servicemodels.BookServiceModel;
import bookstore.domain.servicemodels.CategoryServiceModel;
import bookstore.domain.servicemodels.UserServiceModel;
import bookstore.repository.BookRepository;
import bookstore.repository.UserRepository;
import bookstore.service.BookService;
import config.Mapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;
    private final BookRepository bookRepository;
    private final Mapper mapper = new Mapper();
    private final ValidationServiceImpl userValidationService = new ValidationServiceImpl();

    public BookServiceImpl() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("book_shop");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.bookRepository = new BookRepository(entityManager);
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

    }

    @Override
    public void updateBook(int id, Category category, String title, String author, String isbn, Date publishDate, byte[] image, double price, String description) throws Exception {

    }

    @Override
    public Book findBookByTitle(String title) {
        return this.bookRepository.findByBookTitle(title);
    }

    @Override
    public Book getById(int id) {
        return null;
    }
}

