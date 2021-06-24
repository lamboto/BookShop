import bookstore.entitites.User;
import bookstore.repository.UserRepository;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



import static org.junit.Assert.assertTrue;

public class UserTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static UserRepository userRepository;

    @BeforeClass
    public static void setupClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("book_shop");
        entityManager = entityManagerFactory.createEntityManager();

        userRepository = new UserRepository(entityManager);
    }

    @Test
    public void testCreateUser() {


        User user = new User();

        user.setEmail("davd@abv.bg");
        user.setFullName("Stoyan Kolev");
        user.setPassword("asdasdasd");


        user = userRepository.create(user);


        assertTrue(user.getUserId() > 0);
    }

    @AfterClass
    public static void tearDownClass() {

        entityManager.close();
        entityManagerFactory.close();
    }

}
