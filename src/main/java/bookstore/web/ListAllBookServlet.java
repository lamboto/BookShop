package bookstore.web;


import bookstore.domain.entitites.Category;
import bookstore.domain.servicemodels.BookServiceModel;
import bookstore.domain.servicemodels.UserServiceModel;
import bookstore.domain.view.ListAllBookViewModel;
import bookstore.domain.view.ListAllUserViewModel;
import bookstore.service.impl.BookServiceImpl;
import bookstore.service.impl.UserServiceImpl;
import config.Mapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/admin/list_books")
public class ListAllBookServlet extends HttpServlet {

    private final Mapper mapper = new Mapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        BookServiceImpl bookService = new BookServiceImpl();

        List<BookServiceModel> aLlBooks = bookService.findALl();


        List<ListAllBookViewModel> allBooksModel = aLlBooks.stream().map(e -> this.mapper.map(e, ListAllBookViewModel.class))
                .collect(Collectors.toList());


        req.setAttribute("listBooks", allBooksModel);


        req.getRequestDispatcher("book_list.jsp")
                .forward(req, resp);
    }

}
