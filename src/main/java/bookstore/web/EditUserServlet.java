package bookstore.web;

import bookstore.domain.servicemodels.UserServiceModel;
import bookstore.domain.view.EditUserViewModel;
import bookstore.service.impl.UserServiceImpl;
import config.Mapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import bookstore.domain.entitites.User;

@WebServlet("/admin/edit_user")
public class EditUserServlet extends HttpServlet {

    private final UserServiceImpl userService = new UserServiceImpl();
    private final Mapper mapper = new Mapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = this.userService.getById(id);

        EditUserViewModel editViewModel = this.mapper.map(user, EditUserViewModel.class);
        req.setAttribute("user", editViewModel);

        req.getRequestDispatcher("user_form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullname");

        User userExist = this.userService.findUserByEmail(email);

        if (userExist != null) {
            String message = "Could not update user with this email: " + email + " because already exist!";
            req.setAttribute("message", message);
            req.getRequestDispatcher("message.jsp")
                    .forward(req, resp);
        }

        try {
            this.userService.updateUser(userId, email, password, fullName);
            resp.sendRedirect("/admin/list_users");
        } catch (Exception e) {
            resp.sendRedirect("/admin/update_user");
        }
    }
}
