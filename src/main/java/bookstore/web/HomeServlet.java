package bookstore.web;

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

@WebServlet("")
public class HomeServlet extends HttpServlet {

    private final BookServiceImpl bookService;
    private final Mapper mapper;

    public HomeServlet() {
        this.bookService = new BookServiceImpl();
        this.mapper = new Mapper();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<BookServiceModel> byLastUpdateTime = bookService.findByLastUpdateTime();

        List<ListAllBookViewModel> bookModel = byLastUpdateTime.stream()
                .map(e -> this.mapper.map(e, ListAllBookViewModel.class))
                .collect(Collectors.toList());
        req.setAttribute("newBooks", bookModel);

        req.getRequestDispatcher("index.jsp")
                .forward(req, resp);
    }
}
