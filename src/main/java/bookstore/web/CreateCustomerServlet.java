package bookstore.web;

import bookstore.domain.entitites.Customer;
import bookstore.domain.entitites.User;
import bookstore.service.impl.CustomerServiceImpl;
import config.Mapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/register")
public class CreateCustomerServlet extends HttpServlet {

    private final Mapper mapper;
    private final CustomerServiceImpl customerService;

    public CreateCustomerServlet() {
        this.mapper = new Mapper();
        this.customerService = new CustomerServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("customer_form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String fullName = req.getParameter("fullname");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String address = req.getParameter("address");
        String city = req.getParameter("city");
        String country = req.getParameter("country");
        String phone = req.getParameter("phone");
        String zipCode = req.getParameter("zipcode");


        Customer customerExist = this.customerService.findByEmail(email);

       if (customerExist != null) {
           String message = "Could not register customer with this email.A customer with email" + email + " already exists.";
           req.setAttribute("message", message);
           req.getRequestDispatcher("message.jsp")
                   .forward(req, resp);
       }

        try {
            this.customerService.registerCustomer(email, fullName, password, confirmPassword, phone, address, city, country, zipCode);
            resp.sendRedirect("/index");
        } catch (Exception e) {
            resp.sendRedirect("/register");
        }

    }
}
