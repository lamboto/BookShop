package bookstore.web;

import bookstore.domain.entitites.Customer;
import bookstore.domain.entitites.User;
import bookstore.domain.servicemodels.CustomerServiceModel;
import bookstore.domain.view.EditCustomerViewModel;
import bookstore.domain.view.EditUserViewModel;
import bookstore.repository.CustomerRepository;
import bookstore.service.impl.CustomerServiceImpl;
import config.Mapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/edit_customer")
public class EditCustomerServlet extends HttpServlet {

    private final CustomerServiceImpl customerService;
    private final Mapper mapper;

    public EditCustomerServlet() {
        this.mapper = new Mapper();
        this.customerService = new CustomerServiceImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = this.customerService.getById(id);

        EditCustomerViewModel customerViewModel = this.mapper.map(customer, EditCustomerViewModel.class);
        req.setAttribute("customer", customerViewModel);

        req.getRequestDispatcher("customer_form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int customerId = Integer.parseInt(req.getParameter("customerId"));
        String email = req.getParameter("email");
        String fullName = req.getParameter("fullname");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String country = req.getParameter("country");
        String phone = req.getParameter("phone");
        String zipCode = req.getParameter("zipcode");

        CustomerServiceModel customer = new CustomerServiceModel();

        customer.setCustomerId(customerId);
        customer.setEmail(email);
        customer.setFullName(fullName);
        customer.setAddress(address);
        customer.setCity(city);
        customer.setCountry(country);
        customer.setPhone(phone);
        customer.setZipcode(zipCode);
        customer.setPassword(password);

        Customer customerById = this.customerService.getById(customerId);
        Customer customerByEmail = this.customerService.findByEmail(email);

        String message = "";

        if (customerByEmail != null && customerById.getCustomerId() != customerByEmail.getCustomerId()) {

            message = "Could not update customer with this email: " + email + " because already exist!";
            req.setAttribute("message", message);
            req.getRequestDispatcher("message.jsp")
                    .forward(req, resp);

        } else {
            try {
                this.customerService.updateCustomer(customer);
                resp.sendRedirect("/admin/list_customers");
            } catch (Exception e) {
                message = "Could not find customer with ID: " + customerId;
                req.setAttribute("message", message);
                req.getRequestDispatcher("message.jsp")
                        .forward(req, resp);
            }
        }
    }
}
