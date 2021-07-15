package bookstore.web;

import bookstore.domain.entitites.Customer;
import bookstore.domain.view.EditCustomerViewModel;
import bookstore.service.impl.CustomerServiceImpl;
import config.Mapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/view_profile")
public class ShowCustomerProfileServlet extends HttpServlet {

    private final CustomerServiceImpl customerService;
    private final Mapper mapper;

    public ShowCustomerProfileServlet() {
        this.customerService = new CustomerServiceImpl();
        this.mapper = new Mapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("customer_profile.jsp")
                .forward(req, resp);
    }

}
