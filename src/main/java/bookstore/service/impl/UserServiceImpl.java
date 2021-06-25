package bookstore.service.impl;

import bookstore.entitites.User;
import bookstore.repository.UserRepository;
import bookstore.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;
    private final UserRepository userRepository;

    public UserServiceImpl() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("book_shop");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.userRepository = new UserRepository(entityManager);
    }


    @Override
    public List<User> findALl() {
        return this.userRepository.listAll();
    }
}
