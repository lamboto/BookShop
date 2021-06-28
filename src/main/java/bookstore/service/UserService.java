package bookstore.service;

import bookstore.domain.entitites.User;

import java.util.List;

public interface UserService {
    List<User> findALl();
    void createUser(String email,String password,String fullName);
}
