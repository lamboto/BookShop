package bookstore.service.impl;

import bookstore.domain.entitites.Book;
import bookstore.domain.entitites.Category;
import bookstore.repository.BookRepository;
import bookstore.repository.CategoryRepository;
import bookstore.repository.UserRepository;
import bookstore.service.ValidationService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bookstore.domain.entitites.User;

public class ValidationServiceImpl implements ValidationService {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;

    public ValidationServiceImpl() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("book_shop");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.userRepository = new UserRepository(entityManager);
        this.categoryRepository = new CategoryRepository(entityManager);
        this.bookRepository = new BookRepository(entityManager);
    }


    @Override
    public boolean canCreateUser(String email) {
        return isEmailValid(email);
    }

    @Override
    public boolean canCreateBook(String bookName) {
        return isBookValid(bookName);
    }

    @Override
    public boolean canCreateCategory(String email) {
        return isCategoryNameExist(email);
    }

    private boolean isBookValid(String bookName) {
        Book book = this.bookRepository.findByBookTitle(bookName);

        if (book != null) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isEmailValid(String email) {
        User user = this.userRepository.findUserByEmail(email);

        if (user == null) {
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);

            return matcher.find();
        } else {
            return false;
        }
    }


    @Override
    public boolean isUserIdValid(int id) {
        User user = this.userRepository.get(id);

        if (user != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isCategoryNameExist(String name) {
        Category category = this.categoryRepository.findCategoryByName(name);

        if (category != null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean isCategoryValid(int id) {
        Category category = this.categoryRepository.get(id);
        if (category != null) {
            return true;
        } else {
            return false;
        }
    }


}
