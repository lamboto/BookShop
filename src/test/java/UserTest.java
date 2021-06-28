import bookstore.domain.entitites.User;
import bookstore.repository.UserRepository;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.Assert.*;

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

    @Test
    public void testIfEntityExist() {
        int userId = 1;
        User user = userRepository.get(userId);

        assertNotNull(user);
    }

    @Test
    public void testIfGetUserNotFound() {
        int userId = 99;
        User user = userRepository.get(userId);

        assertNull(user);
    }

    @Test
    public void testDeleteUser() {
        int userId = 2;

        userRepository.delete(userId);
        User user = userRepository.get(userId);
        assertNull(user);
    }

    @Test(expected = Exception.class)
    public void testDeleteNonExistUser() {
        int userId = 99;

        userRepository.delete(userId);
        User user = userRepository.get(userId);
        assertNull(user);
    }

    @Test
    public void testFindAllUsers() {
        List<User> users = userRepository.listAll();

        assertTrue(users.size() > 0);
    }

    @Test
    public void testCountAllUsers() {
        long size = userRepository.count();

        assertEquals(2, size);
    }

    @Test
    public void testUserCreateValidation(){
        String email = "davd@abv.bg";

        User user = userRepository.findUserByEmail(email);

        assertNotNull(user);
    }

    @AfterClass
    public static void tearDownClass() {

        entityManager.close();
        entityManagerFactory.close();
    }

}
