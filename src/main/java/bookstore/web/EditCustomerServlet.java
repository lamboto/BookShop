package bookstore.web;

import bookstore.domain.entitites.Customer;
import bookstore.domain.view.EditCustomerViewModel;
import bookstore.domain.view.EditUserViewModel;
import bookstore.repository.CustomerRepository;
import config.Mapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/edit_customer")
public class EditCustomerServlet extends HttpServlet {

    private final CustomerRepository customerRepository;
    private final Mapper mapper;

    public EditCustomerServlet() {
        this.mapper = new Mapper();
        this.customerRepository = new CustomerRepository();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = this.customerRepository.get(id);

        EditCustomerViewModel customerViewModel = this.mapper.map(customer, EditCustomerViewModel.class);
        req.setAttribute("customer", customerViewModel);

        req.getRequestDispatcher("customer_form.jsp")
                .forward(req, resp);
    }
}
