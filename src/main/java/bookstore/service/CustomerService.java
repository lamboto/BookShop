package bookstore.service;

import bookstore.domain.entitites.Category;
import bookstore.domain.entitites.Customer;
import bookstore.domain.servicemodels.CategoryServiceModel;
import bookstore.domain.servicemodels.CustomerServiceModel;

import java.util.List;

public interface CustomerService {
    List<CustomerServiceModel> findALl();

    void registerCustomer(String email, String fullName, String password, String confirmPassword, String phoneNumber, String address, String city, String zipCode, String country) throws Exception;

    void delete(int id) throws Exception;

    void updateCustomer(CustomerServiceModel customerServiceModel) throws Exception;

    Customer findCustomerByName(String name);

    Customer findByEmail(String email);

    Customer getById(int id);

    Customer login(String email, String password);
}
