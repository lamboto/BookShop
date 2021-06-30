package bookstore.web;

import bookstore.domain.entitites.User;
import bookstore.domain.servicemodels.UserServiceModel;
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

        User userExist = this.userService.findUserByEmail(email);

        if (userExist != null) {
            String message = "Could not create user with this email.A user with email" + email + " already exists.";
            req.setAttribute("message", message);
            req.getRequestDispatcher("message.jsp")
                    .forward(req, resp);
        } else {

            try {
                this.userService.createUser(email, password, fullname);
                resp.sendRedirect("/admin/list_users");
            } catch (Exception e) {
                resp.sendRedirect("/admin/create_user");
            }
        }
    }
}
