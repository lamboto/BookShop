import bookstore.domain.entitites.*;
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

import static org.junit.Assert.*;

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
        review.setHeadline("Another one");
        review.setComment("Ima Review Dobro e");
        review.setReviewTime(new Date());


        Customer customer = new Customer();
        customer.setCustomerId(5);

        Book book = new Book();
        book.setBookId(10);

        review.setCustomer(customer);

        review.setBook(book);
        Review savedReview = reviewRepository.create(review);

        assertTrue(savedReview.getReviewId() > 0);
    }

    @Test
    public void testGet() {
        int reviewId = 1;

        Review review = reviewRepository.get(reviewId);

        assertNotNull(review);
    }

    @Test
    public void testUpdateReview() {
        int reviewId = 1;
        Review review = reviewRepository.get(reviewId);
        review.setHeadline("Ex book");

        Review updatedReview = reviewRepository.update(review);

        assertEquals(review.getHeadline(), updatedReview.getHeadline());
    }

    @Test
    public void listAllTestReview() {

        assertTrue(reviewRepository.listAll().size() > 0);
    }

    @Test
    public void countTestReview() {
        long count = reviewRepository.count();

        assertEquals(1, count);
    }

    @Test
    public void testDeleteReview() {
        int reviewId = 1;

        reviewRepository.delete(reviewId);
        Review review = reviewRepository.get(reviewId);
        assertNull(review);
    }

    @Test
    public void testFindCustomerAndBookNotFound(){
        int customerId = 99;
        int bookId = 100;

        Review result = reviewRepository.findBYCustomerAndBook(customerId,bookId);
        assertNull(result);
    }
    @Test
    public void testFindCustomerAndBook(){
        int customerId = 3;
        int bookId = 10;

        Review result = reviewRepository.findBYCustomerAndBook(customerId,bookId);
        assertNotNull(result);
    }




    @AfterClass
    public static void tearDownClass() {

        entityManager.close();
        entityManagerFactory.close();
    }
}
