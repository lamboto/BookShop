package bookstore.web;

import bookstore.domain.entitites.Book;
import bookstore.domain.entitites.User;
import bookstore.service.BookService;
import bookstore.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/delete_book")
public class DeleteBookServlet extends HttpServlet {

    private final BookServiceImpl bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("id"));


        try {
            this.bookService.delete(bookId);
            resp.sendRedirect("/admin/list_books");
        } catch (Exception e) {
            Book bookExist = this.bookService.getById(bookId);

            if (bookExist == null) {
                String message = "Could not find book with ID " + bookId + ", or it might have been deleted by another admin.";
                req.setAttribute("message", message);
                req.getRequestDispatcher("message.jsp")
                        .forward(req, resp);
            }
        }
    }
}
