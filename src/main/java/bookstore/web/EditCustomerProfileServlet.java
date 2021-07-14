package bookstore.web;

import bookstore.domain.entitites.Customer;
import bookstore.domain.servicemodels.CustomerServiceModel;
import bookstore.domain.view.EditCustomerViewModel;
import bookstore.service.impl.CustomerServiceImpl;
import config.Mapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit_profile")
public class EditCustomerProfileServlet extends HttpServlet {
    private final CustomerServiceImpl customerService;
    private final Mapper mapper;

    public EditCustomerProfileServlet() {
        this.mapper = new Mapper();
        this.customerService = new CustomerServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer customer = (Customer) req.getSession()
                .getAttribute("loggedCustomer");


        EditCustomerViewModel customerViewModel = this.mapper.map(customer, EditCustomerViewModel.class);
        req.setAttribute("customer", customerViewModel);

        req.getRequestDispatcher("edit_profile.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerServiceModel customer = new CustomerServiceModel();

        int customerId = Integer.parseInt(req.getParameter("customerId"));
        String email = req.getParameter("email");
        if (email != null && !email.equals("")) {
            customer.setEmail(email);
        }
        String fullName = req.getParameter("fullname");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String country = req.getParameter("country");
        String phone = req.getParameter("phone");
        String zipCode = req.getParameter("zipcode");

        String password = req.getParameter("password");
        if (password != null && !password.equals("")) {
            customer.setPassword(password);
        }

        customer.setFullName(fullName);
        customer.setAddress(address);
        customer.setCity(city);
        customer.setCountry(country);
        customer.setPhone(phone);
        customer.setZipcode(zipCode);


        try {
            this.customerService.updateCustomer(customer);
            resp.sendRedirect("/view_profile");
        } catch (Exception e) {
            resp.sendRedirect("/edit_profile");
        }

    }
}
