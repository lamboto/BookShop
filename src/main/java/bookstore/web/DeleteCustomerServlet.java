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

@WebServlet("/admin/delete_customer")
public class DeleteCustomerServlet extends HttpServlet {

    private final CustomerServiceImpl customerService;

    public DeleteCustomerServlet() {
        this.customerService = new CustomerServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int customerId = Integer.parseInt(req.getParameter("id"));

        try {
            this.customerService.delete(customerId);
            resp.sendRedirect("/admin/list_customers");
        } catch (Exception e) {
            Customer customer = this.customerService.getById(customerId);

            if (customer == null) {
                String message = "Could not find customer with ID " + customerId + ", or it might have been deleted by another admin.";
                req.setAttribute("message", message);
                req.getRequestDispatcher("message.jsp")
                        .forward(req, resp);
            }
        }
    }
}
