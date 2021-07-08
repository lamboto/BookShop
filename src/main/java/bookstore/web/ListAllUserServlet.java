package bookstore.web;

import bookstore.domain.servicemodels.UserServiceModel;
import bookstore.domain.view.ListAllUserViewModel;
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

@WebServlet("/admin/list_users")
public class ListAllUserServlet extends HttpServlet {

    private final Mapper mapper;
    private final UserServiceImpl userService;

    public ListAllUserServlet() {
        this.mapper = new Mapper();
        this.userService = new UserServiceImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserServiceModel> aLlUsers = this.userService.findALl();


        List<ListAllUserViewModel> allUsersModel = aLlUsers.stream().map(e -> this.mapper.map(e, ListAllUserViewModel.class))
                .collect(Collectors.toList());


        req.setAttribute("listUsers", allUsersModel);


        req.getRequestDispatcher("user_list.jsp")
                .forward(req, resp);
    }
}
