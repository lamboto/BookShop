package bookstore.service.impl;

import bookstore.domain.entitites.User;
import bookstore.domain.servicemodels.UserServiceModel;
import bookstore.repository.UserRepository;
import bookstore.service.UserService;
import config.Mapper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;
    private final UserRepository userRepository;
    private final Mapper mapper = new Mapper();

    public UserServiceImpl() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("book_shop");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.userRepository = new UserRepository(entityManager);
    }


    @Override
    public List<User> findALl() {
        return this.userRepository.listAll();
    }

    @Override
    public void createUser(String email, String password, String fullName) {
        UserServiceModel userServiceModel = new UserServiceModel();
        userServiceModel.setEmail(email);
        userServiceModel.setPassword(password);
        userServiceModel.setFullName(fullName);

        this.userRepository.create(mapper.map(userServiceModel, User.class));
    }
}
