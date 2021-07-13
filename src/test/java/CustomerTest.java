import bookstore.domain.entitites.Category;
import bookstore.domain.entitites.Customer;
import bookstore.repository.CategoryRepository;
import bookstore.repository.CustomerRepository;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Date;

import static org.junit.Assert.*;

public class CustomerTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static CustomerRepository customerRepository;


    @BeforeClass
    public static void setupClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("book_shop");
        entityManager = entityManagerFactory.createEntityManager();

        customerRepository = new CustomerRepository();
    }



    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setEmail("aasd@abv.bg");
        customer.setFullName("Teodor Lamburov");
        customer.setAddress("Shipchenska epopeja");
        customer.setCity("kaazanlak");
        customer.setCountry("Bulgaria");
        customer.setPhone("0895137953");
        customer.setZipcode("6100");
        customer.setPassword("asdasd");
        customer.setRegisterDate(new Date());

        customerRepository.create(customer);

        assertTrue(customer.getCustomerId() > 0);
    }

    @Test
    public void testCheckLogin() {
        String email = "toshkoaa@abv.bg";
        String password = "asdasd";
        boolean isTrue = customerRepository.checkLogin(email, password);
        assertFalse(isTrue);
    }


    @AfterClass
    public static void tearDownClass() {

        entityManager.close();
        entityManagerFactory.close();
    }
}
