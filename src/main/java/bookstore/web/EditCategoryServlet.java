package bookstore.web;

import bookstore.domain.entitites.Category;
import bookstore.domain.entitites.User;
import bookstore.domain.view.EditCategoryViewModel;
import bookstore.service.impl.CategoryServiceImpl;
import config.Mapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/edit_category")
public class EditCategoryServlet extends HttpServlet {

    private final CategoryServiceImpl categoryService = new CategoryServiceImpl();
    private final Mapper mapper = new Mapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Category category = categoryService.getById(id);

        EditCategoryViewModel editCategoryViewModel = this.mapper.map(category, EditCategoryViewModel.class);

        req.setAttribute("category", editCategoryViewModel);

        req.getRequestDispatcher("category_form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("categoryId"));
        String name = req.getParameter("name");


        Category categoryByName = this.categoryService.findCategoryByName(name);

        if (categoryByName != null) {
            String message = "Could not update category with this name: " + name + " because already exist!";
            req.setAttribute("message", message);
            req.getRequestDispatcher("message.jsp")
                    .forward(req, resp);
        } else {

            try {
                this.categoryService.updateCategory(id, name);
                resp.sendRedirect("/admin/list_categories");
            } catch (Exception e) {
                throw new IllegalArgumentException("Cannot update category");
            }
        }
    }
}
