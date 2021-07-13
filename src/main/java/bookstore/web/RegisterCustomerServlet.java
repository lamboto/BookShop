package bookstore.web;

import bookstore.domain.entitites.Customer;
import bookstore.service.impl.CustomerServiceImpl;
import config.Mapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register_customer")
public class RegisterCustomerServlet extends HttpServlet {


    private final Mapper mapper;
    private final CustomerServiceImpl customerService;

    public RegisterCustomerServlet() {
        this.mapper = new Mapper();
        this.customerService = new CustomerServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register_form.jsp")
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

        String message = "";
        if (customerExist != null) {
            message = "Could not register customer with this email.A customer with email" + email + " already exists.";
            req.setAttribute("message", message);
            req.getRequestDispatcher("message.jsp")
                    .forward(req, resp);
        }

        try {
            this.customerService.registerCustomer(email, fullName, password, confirmPassword, phone, address, city, country, zipCode);
            message = "You have register successfully! Thank you.<br/>"
                    + "<a href='login'>Click here</a> to Login";
            req.setAttribute("message", message);
            req.getRequestDispatcher("message.jsp")
                    .forward(req, resp);
        } catch (Exception e) {
            resp.sendRedirect("/register");
        }

    }
}
