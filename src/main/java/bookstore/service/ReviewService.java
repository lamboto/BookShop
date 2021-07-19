package bookstore.service;

import bookstore.domain.entitites.Book;
import bookstore.domain.entitites.Customer;
import bookstore.domain.entitites.Review;
import bookstore.domain.servicemodels.CustomerServiceModel;
import bookstore.domain.servicemodels.ReviewServiceModel;

import java.util.Date;
import java.util.List;

public interface ReviewService {

    List<ReviewServiceModel> findALl();

    void create(double rating, String headline, String comment) throws Exception;

    void delete(int id) throws Exception;

    void updateReview(Review review) throws Exception;

    Review getById(int id);

}
