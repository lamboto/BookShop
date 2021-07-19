package bookstore.repository;

import bookstore.domain.entitites.Review;

import java.util.Date;
import java.util.List;

public class ReviewRepository extends JpaRepository<Review> implements GenericRepository<Review> {

    public ReviewRepository() {
    }


    @Override
    public Review create(Review review) {
        review.setReviewTime(new Date());
        return super.create(review);
    }

    @Override
    public Review update(Review review) {
        review.setReviewTime(new Date());
        return super.update(review);
    }

    @Override
    public Review get(Object id) {
        return super.get(Review.class, id);
    }

    @Override
    public void delete(Object id) {
        this.delete(Review.class, id);
    }

    @Override
    public List<Review> listAll() {
        return super.listAll("Review.findAll");
    }

    @Override
    public long count() {
        return super.count("Review.count");
    }
}
