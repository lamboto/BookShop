package bookstore.web;

import bookstore.domain.entitites.Customer;
import bookstore.domain.entitites.Review;
import bookstore.service.impl.ReviewServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/delete_review")
public class DeleteReviewServlet extends HttpServlet {


    private final ReviewServiceImpl reviewService;

    public DeleteReviewServlet() {
        this.reviewService = new ReviewServiceImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int reviewId = Integer.parseInt(req.getParameter("id"));

        try {
            this.reviewService.delete(reviewId);
            resp.sendRedirect("/admin/list_reviews");
        } catch (Exception e) {
            Review review = this.reviewService.getById(reviewId);

            if (review == null) {
                String message = "Could not find review with ID " + reviewId + ", or it might have been deleted by another admin.";
                req.setAttribute("message", message);
                req.getRequestDispatcher("message.jsp")
                        .forward(req, resp);
            }
        }
    }
}
