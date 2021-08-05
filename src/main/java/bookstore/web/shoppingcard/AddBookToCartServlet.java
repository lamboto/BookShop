package bookstore.web.shoppingcard;

import bookstore.domain.entitites.Book;
import bookstore.repository.BookRepository;
import bookstore.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add_to_cart")
public class AddBookToCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt((req.getParameter("book_id")));

        Object cartObject = req.getSession().getAttribute("cart");

        ShoppingCart shoppingCart = null;

        if (cartObject != null && cartObject instanceof ShoppingCart) {
            shoppingCart = (ShoppingCart) cartObject;
        } else {
            shoppingCart = new ShoppingCart();
            req.getSession().setAttribute("cart", shoppingCart);
        }

        BookServiceImpl bookService = new BookServiceImpl();
        Book book = bookService.getById(bookId);

        shoppingCart.addItem(book);

        String cartPage = req.getContextPath().concat("/view_cart");

        resp.sendRedirect(cartPage);
    }
}
