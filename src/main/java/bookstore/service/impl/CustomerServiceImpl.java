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
    private final ValidationServiceImpl validationService;

    public CustomerServiceImpl() {
        this.mapper = new ModelMapper();
        this.customerRepository = new CustomerRepository();
        this.validationService = new ValidationServiceImpl();
    }


    @Override
    public void delete(int id) throws Exception {
        if (this.validationService.isCustomerValidToDelete(id)) {
            this.customerRepository.delete(id);
        } else {
            throw new Exception("Customer cannot be deleted");
        }
    }

    @Override
    public void updateCustomer(CustomerServiceModel customerServiceModel) throws Exception {
        this.customerRepository.update(this.mapper.map(customerServiceModel, Customer.class));
    }

    @Override
    public void updateCustomer(Customer customer) throws Exception {

        this.customerRepository.update(customer);
    }

    @Override
    public Customer findCustomerByName(String name) {
        return null;
    }

    @Override
    public Customer findByEmail(String email) {
        return this.customerRepository.findCustomerByEmail(email);
    }

    @Override
    public List<CustomerServiceModel> findALl() {
        return this.customerRepository.listAll().stream()
                .map(e -> this.mapper.map(e, CustomerServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void registerCustomer(String email, String fullName, String password, String confirmPassword, String phoneNumber, String address, String city, String zipCode, String country) throws Exception {

        if (validationService.canCreateCustomer(email, password, confirmPassword)) {
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
        } else {
            throw new Exception("Customer cannot be created");
        }


    }

    @Override
    public Customer getById(int id) {
        return this.customerRepository.get(id);
    }

    @Override
    public Customer login(String email, String password) {
        boolean loginResult = this.customerRepository.checkLogin(email, password);
        if (loginResult) {
            return this.customerRepository.findCustomerByEmail(email);
        } else {
            return null;
        }
    }
}
