package bookstore.service.impl;

import bookstore.domain.entitites.Book;
import bookstore.domain.entitites.Customer;
import bookstore.domain.entitites.Review;
import bookstore.domain.servicemodels.BookServiceModel;
import bookstore.domain.servicemodels.CustomerServiceModel;
import bookstore.domain.servicemodels.ReviewServiceModel;
import bookstore.repository.ReviewRepository;
import bookstore.service.ReviewService;
import config.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final Mapper mapper;
    private final ValidationServiceImpl validationService;

    public ReviewServiceImpl() {
        this.reviewRepository = new ReviewRepository();
        this.mapper = new Mapper();
        this.validationService = new ValidationServiceImpl();
    }


    @Override
    public List<ReviewServiceModel> findALl() {
        return this.reviewRepository.listAll()
                .stream().map(e -> this.mapper.map(e, ReviewServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void create(double rating, String headline, String comment, Book book, Customer customer) throws Exception {
        ReviewServiceModel reviewServiceModel = new ReviewServiceModel();
        reviewServiceModel.setRating(rating);
        reviewServiceModel.setHeadline(headline);
        reviewServiceModel.setComment(comment);
        reviewServiceModel.setBook(this.mapper.map(book, BookServiceModel.class));
        reviewServiceModel.setCustomer(this.mapper.map(customer, CustomerServiceModel.class));

        this.reviewRepository.create(this.mapper.map(reviewServiceModel, Review.class));
    }


    @Override
    public void delete(int id) throws Exception {
        if (this.validationService.isReviewValidToDelete(id)) {
            this.reviewRepository.delete(id);
        } else {
            throw new Exception("Review cannot be deleted");
        }
    }

    @Override
    public void updateReview(Review review) throws Exception {
        this.reviewRepository.update(review);
    }


    @Override
    public Review getById(int id) {
        return this.reviewRepository.get(id);
    }

    @Override
    public ReviewServiceModel findBYCustomerAndBook(int customerId, int bookId) {
        Review result = this.reviewRepository.findBYCustomerAndBook(customerId, bookId);
        if (result == null) {
            return null;
        }
        return this.mapper.map(result, ReviewServiceModel.class);
    }


}
