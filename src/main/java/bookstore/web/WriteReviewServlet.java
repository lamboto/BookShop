package bookstore.web;

import bookstore.domain.entitites.Book;
import bookstore.service.impl.BookServiceImpl;
import bookstore.service.impl.ReviewServiceImpl;
import org.modelmapper.ModelMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/write_review")
public class WriteReviewServlet extends HttpServlet {

    private final ReviewServiceImpl reviewService;
    private final ModelMapper modelMapper;
    private final BookServiceImpl bookService;

    public WriteReviewServlet() {
        this.bookService = new BookServiceImpl();
        this.reviewService = new ReviewServiceImpl();
        this.modelMapper = new ModelMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("book_id"));
        Book book = this.bookService.getById(bookId);

        req.setAttribute("book",book);
        req.getRequestDispatcher("review_form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
