import bookstore.domain.entitites.Category;
import bookstore.domain.entitites.User;
import bookstore.repository.CategoryRepository;
import bookstore.repository.UserRepository;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class CategoryTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static CategoryRepository categoryRepository;


    @BeforeClass
    public static void setupClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("book_shop");
        entityManager = entityManagerFactory.createEntityManager();

        categoryRepository = new CategoryRepository();
    }

    @Test
    public void testCreateCategory() {
        Category category = new Category();
        category.setName("History");

        categoryRepository.create(category);

        assertTrue(category.getCategoryId() > 0);
    }

    @Test
    public void testIfEntityExist() {
        int categoryID = 1;
        Category category = categoryRepository.get(categoryID);

        assertNotNull(category);
    }

    @Test
    public void testIfGetUserNotFound() {
        int categoryId = 99;
        Category category = categoryRepository.get(categoryId);

        assertNull(category);
    }

    @AfterClass
    public static void tearDownClass() {

        entityManager.close();
        entityManagerFactory.close();
    }

}
