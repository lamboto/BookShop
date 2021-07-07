package bookstore.web;


import bookstore.domain.entitites.Book;
import bookstore.domain.entitites.Category;
import bookstore.domain.servicemodels.CategoryServiceModel;
import bookstore.domain.view.ListAllCategoryViewModel;
import bookstore.service.impl.BookServiceImpl;
import bookstore.service.impl.CategoryServiceImpl;
import config.Mapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@WebServlet("/admin/create_book")
@MultipartConfig(
        fileSizeThreshold = 1024 * 10,
        maxFileSize = 1024 * 300,
        maxRequestSize = 1024 * 1024
)
public class CreateBookServlet extends HttpServlet {
    private final Mapper mapper = new Mapper();
    private final BookServiceImpl bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryServiceImpl categoryService = new CategoryServiceImpl();

        List<CategoryServiceModel> categoryServiceModel = categoryService.findALl();

        List<ListAllCategoryViewModel> categoryViewModels = categoryServiceModel.stream()
                .map(e -> this.mapper.map(e, ListAllCategoryViewModel.class))
                .collect(Collectors.toList());

        req.setAttribute("listCategories", categoryViewModels);
        req.getRequestDispatcher("book_form.jsp")
                .forward(req, resp);
    }


    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryServiceImpl categoryService = new CategoryServiceImpl();
        int categoryId = Integer.parseInt(req.getParameter("category"));
        Category category = categoryService.getById(categoryId);
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String isbn = req.getParameter("isbn");


        Date publishDate = null;
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        try {
            publishDate = formatter.parse(req.getParameter("publishDate"));
        } catch (ParseException e) {
            e.printStackTrace();
            throw new ServletException("Error parsing publish date (format is MM/dd/yyyy)");
        }

        Part part = req.getPart("image");

        byte[] imageBytes = bookService.getBytes(part);

        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");

        Book bookExist = this.bookService.findBookByTitle(title);

        if (bookExist != null) {
            String message = "Could not create book with this title.A book with this title " + title + " already exists.";
            req.setAttribute("message", message);
            req.getRequestDispatcher("message.jsp")
                    .forward(req, resp);
        }

        try {
            this.bookService.createBook(category, title, author, isbn, publishDate, imageBytes, price, description);
            resp.sendRedirect("/admin/list_books");
        } catch (Exception e) {
            resp.sendRedirect("/admin/create_user");
        }

    }
}
