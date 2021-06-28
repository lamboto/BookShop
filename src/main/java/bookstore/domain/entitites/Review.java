package bookstore.domain.entitites;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "reviews", schema = "book_shop")
public class Review {
    private int reviewId;
    private int rating;
    private String headline;
    private String comment;
    private Timestamp reviewTime;
    private Book bookByBookId;
    private Customer customerByCustomerId;

    @Id
    @Column(name = "review_id")
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    @Basic
    @Column(name = "rating")
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "headline")
    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "review_time")
    public Timestamp getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Timestamp reviewTime) {
        this.reviewTime = reviewTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return reviewId == review.reviewId && rating == review.rating && Objects.equals(headline, review.headline) && Objects.equals(comment, review.comment) && Objects.equals(reviewTime, review.reviewTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, rating, headline, comment, reviewTime);
    }

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", nullable = false)
    public Book getBooksByBookId() {
        return bookByBookId;
    }

    public void setBooksByBookId(Book bookByBookId) {
        this.bookByBookId = bookByBookId;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    public Customer getCustomersByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomersByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }
}
