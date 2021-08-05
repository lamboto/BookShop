package bookstore.web.shoppingcard;

import bookstore.domain.entitites.Book;
import bookstore.repository.BookRepository;
import bookstore.service.BookService;
import bookstore.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/view_cart")
public class ViewCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object cartObject = req.getSession().getAttribute("cart");
        if (cartObject == null) {
            ShoppingCart shoppingCart = new ShoppingCart();
            req.getSession().setAttribute("cart", shoppingCart);

            BookRepository bookRepository = new BookRepository();
            Book book1 = bookRepository.get(21);

            shoppingCart.addItem(book1);
        }


        req.getRequestDispatcher("shopping_cart.jsp")
                .forward(req, resp);
    }
}
