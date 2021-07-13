package bookstore.repository;

import bookstore.domain.entitites.Book;
import bookstore.domain.entitites.Category;
import bookstore.domain.entitites.Customer;
import bookstore.domain.entitites.User;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository extends JpaRepository<Customer> implements GenericRepository<Customer> {

    public CustomerRepository() {
    }

    @Override
    public Customer get(Object id) {
        return super.get(Customer.class, id);
    }

    @Override
    public Customer create(Customer customer) {
        customer.setRegisterDate(new Date());
        return super.create(customer);
    }

    @Override
    public Customer update(Customer customer) {
        customer.setRegisterDate(new Date());
        return super.update(customer);
    }

    @Override
    public void delete(Object id) {
        super.delete(Customer.class, id);
    }

    @Override
    public List<Customer> listAll() {
        return super.listAll("Customer.findAll");
    }


    @Override
    public long count() {
        return super.count("Customer.count");
    }

    public boolean checkLogin(String email, String password) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("email", email);
        parameters.put("password", password);
        List<Customer> listCustomers = super.findWithNamedQuery("Customer.checkLogin", parameters);
        if (listCustomers.size() == 1) {
            return true;
        }
        return false;
    }

    public Customer findCustomerByEmail(String email) {
        List<Customer> listCustomers = super.findWithNamedQuery("Customer.findByEmail", "email", email);
        if (listCustomers != null && listCustomers.size() > 0) {
            return listCustomers.get(0);
        }
        return null;
    }
}
