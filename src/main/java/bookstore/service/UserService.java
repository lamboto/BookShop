package bookstore.service;

import bookstore.domain.entitites.User;
import bookstore.domain.servicemodels.UserServiceModel;

import java.util.List;

public interface UserService {
    List<UserServiceModel> findALl();

    void createUser(String email, String password, String fullName) throws Exception;

    void delete(int id);

    void updateUser(int id, String email, String password, String fullName) throws Exception;

    UserServiceModel findUserByEmail(String email);

    User getById(int id);
}
