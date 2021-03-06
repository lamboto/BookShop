package bookstore.service;

public interface ValidationService {
    boolean canCreateUser(String email);
    boolean canCreateCategory(String email);
    boolean isUserIdValid(int id);
    boolean isCategoryNameExist(String name);
    boolean isCategoryValid(int id);
    boolean canCreateBook(String book);
    boolean canCreateCustomer(String email,String password,String confirmPassword);

}
