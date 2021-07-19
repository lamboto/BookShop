package bookstore.web;

import bookstore.domain.entitites.Book;
import bookstore.domain.entitites.Customer;
import bookstore.domain.entitites.Review;
import bookstore.domain.view.EditReviewViewModel;
import bookstore.repository.CustomerRepository;
import bookstore.service.impl.BookServiceImpl;
import bookstore.service.impl.CustomerServiceImpl;
import bookstore.service.impl.ReviewServiceImpl;
import config.Mapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/edit_review")
public class EditReviewServlet extends HttpServlet {

    private final Mapper mapper;
    private final ReviewServiceImpl reviewService;
    private final BookServiceImpl bookService;
    private final CustomerServiceImpl customerService;

    public EditReviewServlet() {
        this.customerService = new CustomerServiceImpl();
        this.bookService = new BookServiceImpl();
        this.mapper = new Mapper();
        this.reviewService = new ReviewServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Review review = this.reviewService.getById(id);


        EditReviewViewModel editReviewViewModel = this.mapper.map(review, EditReviewViewModel.class);

        req.setAttribute("review", editReviewViewModel);

        req.getRequestDispatcher("review_form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("reviewId"));
        Review review = this.reviewService.getById(id);


        String headline = req.getParameter("headline");
        String comment = req.getParameter("comment");

        review.setReviewId(id);
        review.setHeadline(headline);
        review.setComment(comment);

        try {
            this.reviewService.updateReview(review);
            resp.sendRedirect("/admin/list_reviews");
        } catch (Exception e) {
            resp.sendRedirect("/admin/edit_review");
        }
    }
}
