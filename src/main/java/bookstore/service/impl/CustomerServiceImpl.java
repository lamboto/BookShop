package bookstore.service.impl;

import bookstore.domain.entitites.Customer;
import bookstore.domain.servicemodels.CustomerServiceModel;
import bookstore.repository.CustomerRepository;
import bookstore.service.CustomerService;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;

    public CustomerServiceImpl() {
        this.mapper = new ModelMapper();
        this.customerRepository = new CustomerRepository();
    }


    @Override
    public void delete(int id) throws Exception {

    }

    @Override
    public void updateCustomer(int id, String name) throws Exception {

    }

    @Override
    public Customer findCustomerByName(String name) {
        return null;
    }

    @Override
    public List<CustomerServiceModel> findALl() {
        return this.customerRepository.listAll().stream()
                .map(e -> this.mapper.map(e, CustomerServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void createCustomer(String email, String fullName, String password, String confirmPassword, String phoneNumber, String address, String city, String zipCode, String country) throws Exception {

        CustomerServiceModel customerServiceModel = new CustomerServiceModel();
        customerServiceModel.setEmail(email);
        customerServiceModel.setFullName(fullName);
        customerServiceModel.setPassword(password);
        customerServiceModel.setPhone(phoneNumber);
        customerServiceModel.setAddress(address);
        customerServiceModel.setCity(city);
        customerServiceModel.setZipcode(zipCode);
        customerServiceModel.setCountry(country);
        this.customerRepository.create(this.mapper.map(customerServiceModel, Customer.class));

    }

    @Override
    public Customer getById(int id) {
        return null;
    }
}
