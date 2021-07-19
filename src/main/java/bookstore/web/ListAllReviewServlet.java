package bookstore.web;

import bookstore.domain.servicemodels.BookServiceModel;
import bookstore.domain.servicemodels.ReviewServiceModel;
import bookstore.domain.view.ListAllBookViewModel;
import bookstore.domain.view.ListAllReviewViewModel;
import bookstore.service.ReviewService;
import bookstore.service.impl.BookServiceImpl;
import bookstore.service.impl.ReviewServiceImpl;
import config.Mapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/admin/list_reviews")
public class ListAllReviewServlet extends HttpServlet {

    private final Mapper mapper;
    private final ReviewServiceImpl reviewService;


    public ListAllReviewServlet() {
        this.mapper = new Mapper();
        this.reviewService = new ReviewServiceImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<ReviewServiceModel> aLlReviews = this.reviewService.findALl();


        List<ListAllReviewViewModel> allReviewsModel = aLlReviews.stream().map(e -> this.mapper.map(e, ListAllReviewViewModel.class))
                .collect(Collectors.toList());


        req.setAttribute("listReviews", allReviewsModel);

        req.getRequestDispatcher("review_list.jsp")
                .forward(req, resp);
    }
}
