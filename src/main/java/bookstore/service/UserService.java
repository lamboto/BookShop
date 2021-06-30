package bookstore.service;

import bookstore.domain.servicemodels.UserServiceModel;
import bookstore.domain.entitites.User;
import java.util.List;

public interface UserService {
    List<UserServiceModel> findALl();

    void createUser(String email, String password, String fullName) throws Exception;

    void delete(int id) throws Exception;

    void updateUser(int id, String email, String password, String fullName) throws Exception;

    User findUserByEmail(String email);

    User getById(int id);
}
