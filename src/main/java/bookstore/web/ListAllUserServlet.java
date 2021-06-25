package bookstore.web;

import bookstore.entitites.User;
import bookstore.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/list_users")
public class ListAllUserServlet extends HttpServlet {

    private final UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> aLlUsers = userService.findALl();

        req.setAttribute("listUsers",aLlUsers);

        req.getRequestDispatcher("user_list.jsp")
                .forward(req, resp);
    }
}
