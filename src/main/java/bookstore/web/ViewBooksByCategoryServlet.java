package bookstore.web;

import bookstore.domain.entitites.Category;
import bookstore.domain.servicemodels.BookServiceModel;
import bookstore.domain.servicemodels.CategoryServiceModel;
import bookstore.domain.view.ListAllBookViewModel;
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

@WebServlet("/view_category")
public class ViewBooksByCategoryServlet extends HttpServlet {
    private final Mapper mapper;
    private final CategoryServiceImpl categoryService;

    public ViewBooksByCategoryServlet() {
        this.mapper = new Mapper();
        this.categoryService = new CategoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int categoryId = Integer.parseInt(req.getParameter("id"));




        BookServiceImpl bookService = new BookServiceImpl();


        Category category = categoryService.getById(categoryId);

        List<BookServiceModel> aLlBooks = bookService.findByCategoryId(categoryId);
        List<ListAllBookViewModel> allBooksModel = aLlBooks.stream().map(e -> this.mapper.map(e, ListAllBookViewModel.class))
                .collect(Collectors.toList());


        req.setAttribute("category", category);
        req.setAttribute("listBooks", allBooksModel);


        req.getRequestDispatcher("book_list_by_category.jsp")
                .forward(req, resp);
    }
}
