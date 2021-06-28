package bookstore.web;

import bookstore.domain.entitites.User;
import bookstore.domain.view.ListAllUserViewModel;
import bookstore.service.impl.UserServiceImpl;
import config.Mapper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/edit_user")
public class EditUserServlet extends HttpServlet {

    private final UserServiceImpl userService = new UserServiceImpl();
    private final Mapper mapper = new Mapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = this.userService.getById(id);

        ListAllUserViewModel editViewModel = this.mapper.map(user, ListAllUserViewModel.class);

        RequestDispatcher dispatcher = req.getRequestDispatcher("user_form.jsp");
        req.setAttribute("user", editViewModel);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
}
