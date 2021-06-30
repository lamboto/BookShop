package bookstore.web;


import bookstore.domain.servicemodels.CategoryServiceModel;
import bookstore.domain.view.ListAllCategoryViewModel;
import bookstore.service.impl.CategoryServiceImpl;
import config.Mapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/admin/list_categories")
public class ListAllCategoryServlet extends HttpServlet {

    private final Mapper mapper = new Mapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryServiceImpl categoryService = new CategoryServiceImpl();

        List<CategoryServiceModel> categoryServiceModel = categoryService.findALl();

        List<ListAllCategoryViewModel> categoryViewModels = categoryServiceModel.stream()
                .map(e -> this.mapper.map(e, ListAllCategoryViewModel.class))
                .collect(Collectors.toList());

        req.setAttribute("listCategories", categoryViewModels);

        req.getRequestDispatcher("category_list.jsp")
        .forward(req,resp);
    }

}
