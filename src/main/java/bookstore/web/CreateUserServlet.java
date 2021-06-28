package bookstore.web;

import bookstore.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/create_user")
public class CreateUserServlet extends HttpServlet {

    private final UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("user_form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String fullname = req.getParameter("fullname");
        String password = req.getParameter("password");

        try {
            this.userService.createUser(email, password, fullname);
            resp.sendRedirect("/admin/list_users");
        } catch (Exception e) {
            resp.sendRedirect("/admin/create_user");
        }
    }
}
