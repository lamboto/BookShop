package bookstore.web;

import bookstore.domain.entitites.User;
import bookstore.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/delete_user")
public class DeleteUserServlet extends HttpServlet {

    private final UserServiceImpl userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("id"));




        try {
            this.userService.delete(userId);
            resp.sendRedirect("/admin/list_users");
        } catch (Exception e) {
            User userExist = this.userService.getById(userId);

            if (userExist == null) {
                String message = "Could not find user with ID "+userId+", or it might have been deleted by another admin.";
                req.setAttribute("message", message);
                req.getRequestDispatcher("message.jsp")
                        .forward(req, resp);
            }
        }
    }
}
