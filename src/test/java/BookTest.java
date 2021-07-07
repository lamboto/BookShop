import bookstore.domain.entitites.Book;
import bookstore.domain.entitites.Category;
import bookstore.repository.BookRepository;
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
import java.util.List;

import static org.junit.Assert.*;

public class BookTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static BookRepository bookRepository;


    @BeforeClass
    public static void setupClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("book_shop");
        entityManager = entityManagerFactory.createEntityManager();

        bookRepository = new BookRepository(entityManager);
    }

    @Test
    public void TestCreateBook() throws ParseException, IOException {
        Book book = new Book();

        Category category = new Category("Java");
        category.setCategoryId(9);

        book.setCategory(category);

        book.setTitle("Effective Java (2nd Edition)");
        book.setAuthor("Joshua Bloch");
        book.setDescription("New coverage of generics, enums, annotations, autoboxing, the for-each loop.");
        book.setIsbn("032141231");
        book.setPrice(38.87);

        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date publishDate = formatter.parse("05/28/2008");
        book.setPublishDate(publishDate);

        String imagePath = "C:\\Users\\t_lamburov\\Desktop\\BookShop\\src\\main\\webapp\\resources\\images\\Effective Java.JPG";
        byte[] imageBytes = Files.readAllBytes(Path.of(imagePath));
        book.setImage(imageBytes);

        Book createdBook = bookRepository.create(book);
        assertTrue(createdBook.getBookId() > 0);
    }

    @Test
    public void testFindAllBooks() {
        List<Book> books = bookRepository.listAll();

        assertTrue(books.size() > 0);
    }

    @Test
    public void testListNewBooks() {
        List<Book> books = bookRepository.listNewestBooks();
        for (Book book : books) {
            System.out.println(book.getTitle()+"-" + book.getPublishDate());
        }

        assertEquals(4,books.size());
    }

    @Test
    public void testSearchBookKeyword() {

        List<Book> books = bookRepository.findByKeyword("dem");


        assertEquals(1,books.size());
    }

    @Test
    public void testListByCategory() {
        int categoryId = 7;
        List<Book> books = bookRepository.findAllBooksByCategory(categoryId);

        assertTrue(books.size() > 0);
    }
    @AfterClass
    public static void tearDownClass() {

        entityManager.close();
        entityManagerFactory.close();
    }
}
