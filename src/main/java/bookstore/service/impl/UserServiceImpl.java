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
import java.util.stream.Collectors;

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
    public List<UserServiceModel> findALl() {
        return this.userRepository.listAll().stream()
                .map(e -> mapper.map(e, UserServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void createUser(String email, String password, String fullName) throws Exception {
        User user = this.userRepository.findUserByEmail(email);
        if (user != null){
            throw new Exception("User cannot be created.User with this email already exist!");
        }

        UserServiceModel userServiceModel = new UserServiceModel();
        userServiceModel.setEmail(email);
        userServiceModel.setPassword(password);
        userServiceModel.setFullName(fullName);


        this.userRepository.create(mapper.map(userServiceModel, User.class));
    }

    @Override
    public UserServiceModel findUserByEmail(String email) {
        User user = this.userRepository.findUserByEmail(email);
        return this.mapper.map(user, UserServiceModel.class);
    }

    @Override
    public User getById(int id) {
        return this.userRepository.get(id);
    }
}
