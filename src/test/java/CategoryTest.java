import bookstore.entitites.Category;
import bookstore.entitites.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CategoryTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("book_shop");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Category category = new Category();

        category.setName("Drama");



        entityManager.getTransaction().begin();
        entityManager.persist(category);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
