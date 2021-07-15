package bookstore.web;

import bookstore.domain.entitites.Customer;
import bookstore.domain.entitites.User;
import bookstore.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class CustomerLoginServlet extends HttpServlet {

    private final CustomerServiceImpl customerService;

    public CustomerLoginServlet() {
        this.customerService = new CustomerServiceImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Customer customer = this.customerService.login(email, password);

        if (customer == null) {
            resp.sendRedirect("/login");
        } else {
            req.getSession()
                    .setAttribute("loggedCustomer", customer);
            resp.sendRedirect("/view_profile");
        }

    }
}
