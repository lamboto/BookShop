import bookstore.domain.entitites.Book;
import bookstore.domain.entitites.Category;
import bookstore.domain.entitites.Customer;
import bookstore.domain.entitites.Review;
import bookstore.repository.BookRepository;
import bookstore.repository.CustomerRepository;
import bookstore.repository.ReviewRepository;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReviewTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static ReviewRepository reviewRepository;
    private static BookRepository bookRepository;
    private static CustomerRepository customerRepository;


    @BeforeClass
    public static void setupClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("book_shop");
        entityManager = entityManagerFactory.createEntityManager();

        customerRepository = new CustomerRepository();
        bookRepository = new BookRepository();
        reviewRepository = new ReviewRepository();
    }


    @Test
    public void testCreateReview() throws ParseException, IOException {
        Review review = new Review();
        review.setRating(5);
        review.setHeadline("Ludi hora");
        review.setComment("Losho izpulneno");
        review.setReviewTime(new Date());


        Customer customer = new Customer();
        customer.setCustomerId(5);

        Book book = new Book();
        book.setBookId(9);

        review.setCustomer(customer);

        review.setBook(book);
        Review savedReview = reviewRepository.create(review);

        assertTrue(savedReview.getReviewId() > 0);
    }


    @AfterClass
    public static void tearDownClass() {

        entityManager.close();
        entityManagerFactory.close();
    }
}
