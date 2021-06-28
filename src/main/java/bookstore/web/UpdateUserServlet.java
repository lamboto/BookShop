package bookstore.web;

import bookstore.service.impl.UserServiceImpl;
import config.Mapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/update_user")
public class UpdateUserServlet extends HttpServlet {
    private final UserServiceImpl userService = new UserServiceImpl();
    private final Mapper mapper = new Mapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullname");

        try {
            this.userService.updateUser(userId, email, password, fullName);
            resp.sendRedirect("/admin/list_users");
        } catch (Exception e) {
            resp.sendRedirect("/admin/update_user");
        }

    }
}
