package bookstore.web;

import bookstore.domain.entitites.User;
import bookstore.service.impl.CategoryServiceImpl;
import bookstore.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/delete_category")
public class DeleteCategoryServlet extends HttpServlet {

    private final CategoryServiceImpl categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int categoryId = Integer.parseInt(req.getParameter("id"));


        try {
            this.categoryService.delete(categoryId);
            resp.sendRedirect("/admin/list_categories");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
