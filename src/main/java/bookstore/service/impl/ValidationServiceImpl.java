package bookstore.service.impl;

import bookstore.domain.entitites.*;
import bookstore.repository.*;
import bookstore.service.ValidationService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationServiceImpl implements ValidationService {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;
    private final CustomerRepository customerRepository;
    private final ReviewRepository reviewRepository;

    public ValidationServiceImpl() {
        this.userRepository = new UserRepository();
        this.categoryRepository = new CategoryRepository();
        this.bookRepository = new BookRepository();
        this.customerRepository = new CustomerRepository();
        this.reviewRepository = new ReviewRepository();
    }


    @Override
    public boolean canCreateCustomer(String email, String password, String confirmPassword) {
        return isCustomerEmailValid(email)
                && arePasswordMatching(password, confirmPassword);
    }

    private boolean isCustomerEmailValid(String email) {
        Customer customer = this.customerRepository.findCustomerByEmail(email);
        if (customer == null) {
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);

            return matcher.find();
        } else {
            return false;
        }
    }

    private boolean arePasswordMatching(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }


    @Override
    public boolean canCreateUser(String email) {
        return isEmailValid(email);
    }

    @Override
    public boolean canCreateBook(String bookName) {
        return isBookNameExist(bookName);
    }

    @Override
    public boolean canCreateCategory(String email) {
        return isCategoryNameExist(email);
    }

    public boolean isReviewValidToDelete(int id) {
        Review review = this.reviewRepository.get(id);

        if (review != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBookValidToDelete(int id) {
        Book book = this.bookRepository.get(id);

        if (book != null) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isCustomerValidToDelete(int id) {
        Customer customer = this.customerRepository.get(id);

        if (customer != null) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isBookNameExist(String bookName) {
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
