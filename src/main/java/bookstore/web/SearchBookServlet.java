package bookstore.web;

import bookstore.domain.entitites.Book;
import bookstore.domain.servicemodels.BookServiceModel;
import bookstore.domain.view.ListAllBookViewModel;
import bookstore.domain.view.ListAllUserViewModel;
import bookstore.service.impl.BookServiceImpl;
import config.Mapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/search")
public class SearchBookServlet extends HttpServlet {
    private final Mapper mapper = new Mapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookServiceImpl bookService = new BookServiceImpl();
        String keyword = req.getParameter("keyword");

        List<ListAllBookViewModel> result = null;


        if (keyword.equals("")) {
            result = bookService.findALl().stream()
                    .map(e -> this.mapper.map(e, ListAllBookViewModel.class))
                    .collect(Collectors.toList());
            ;
        } else {
            result = bookService.findByKeyword(keyword).stream()
                    .map(e -> this.mapper.map(e, ListAllBookViewModel.class))
                    .collect(Collectors.toList());
            ;
        }


        req.setAttribute("keyword", keyword);
        req.setAttribute("result", result);


        req.getRequestDispatcher("book_search.jsp")
                .forward(req, resp);
    }
}
