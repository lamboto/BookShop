package bookstore.service;

import bookstore.domain.entitites.Category;
import bookstore.domain.entitites.Customer;
import bookstore.domain.servicemodels.CategoryServiceModel;
import bookstore.domain.servicemodels.CustomerServiceModel;

import java.util.List;

public interface CustomerService {
    List<CustomerServiceModel> findALl();

    void createCustomer(String email,String fullName,String password,String confirmPassword,String phoneNumber,String address,String city,String zipCode,String country) throws Exception;

    void delete(int id) throws Exception;

    void updateCustomer(int id, String name) throws Exception;

    Customer findCustomerByName(String name);


    Customer getById(int id);
}
