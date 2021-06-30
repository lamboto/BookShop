package bookstore.service;

public interface UserValidationService {
    boolean canCreateUser(String email);
    boolean isIdValid(int id);
}
