package bookstore.web;

import bookstore.domain.servicemodels.CustomerServiceModel;
import bookstore.domain.servicemodels.UserServiceModel;
import bookstore.domain.view.ListAllCustomerViewModel;
import bookstore.domain.view.ListAllUserViewModel;
import bookstore.service.impl.CustomerServiceImpl;
import bookstore.service.impl.UserServiceImpl;
import config.Mapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/admin/list_customers")
public class ListAllCustomerServlet extends HttpServlet {
    private final Mapper mapper;
    private final CustomerServiceImpl customerService;

    public ListAllCustomerServlet() {
        this.mapper = new Mapper();
        this.customerService = new CustomerServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<CustomerServiceModel> aLlCustomers = this.customerService.findALl();


        List<ListAllCustomerViewModel> allUsersModel = aLlCustomers.stream().map(e -> this.mapper.map(e, ListAllCustomerViewModel.class))
                .collect(Collectors.toList());


        req.setAttribute("listCustomers", allUsersModel);


        req.getRequestDispatcher("customer_list.jsp")
                .forward(req, resp);
    }
}
