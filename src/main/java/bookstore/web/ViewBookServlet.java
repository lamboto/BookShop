package bookstore.web;

import bookstore.domain.entitites.Book;
import bookstore.domain.servicemodels.CategoryServiceModel;
import bookstore.domain.view.DetailBookViewModel;
import bookstore.domain.view.ListAllCategoryViewModel;
import bookstore.service.impl.BookServiceImpl;
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

@WebServlet("/view_book")
public class ViewBookServlet extends HttpServlet {

    private final Mapper mapper = new Mapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryServiceImpl categoryService = new CategoryServiceImpl();
        BookServiceImpl bookService = new BookServiceImpl();

        List<CategoryServiceModel> categoryServiceModel = categoryService.findALl();

        List<ListAllCategoryViewModel> categoryViewModels = categoryServiceModel.stream()
                .map(e -> this.mapper.map(e, ListAllCategoryViewModel.class))
                .collect(Collectors.toList());

        req.setAttribute("allCategories", categoryViewModels);

        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookService.getById(id);

        DetailBookViewModel bookViewModel = this.mapper.map(book, DetailBookViewModel.class);

        req.setAttribute("book", bookViewModel);

        req.getRequestDispatcher("book_detail.jsp")
                .forward(req, resp);
    }
}
