package bookstore.domain.entitites;

import javax.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "reviews", schema = "book_shop")
@NamedQueries({
        @NamedQuery(name = "Review.findByCustomerAndBook", query = "select r from Review r where r.customer.customerId = : customerId and r.book.bookId = : bookId"),
        @NamedQuery(name = "Review.findAll", query = "select r from Review r order by r.reviewTime desc"),
        @NamedQuery(name = "Review.listByBook", query = "select r from Review r where r.book.bookId = : bookId"),
        @NamedQuery(name = "Review.listByCustomer", query = "select r from Review r where r.customer.customerId = : customerId"),
        @NamedQuery(name = "Review.countByBook", query = "select count(r.reviewId) from Review r where r.book.bookId = : bookId"),
        @NamedQuery(name = "Review.countByCustomer", query = "select count(r.reviewId) from Review r where r.customer.customerId = : customerId"),
        @NamedQuery(name = "Review.listMostRecent", query = "select r from Review r order by r.reviewTime desc "),
        @NamedQuery(name = "Review.listMostFavored", query = "select r from Review r order by r.rating desc"),
        @NamedQuery(name = "Review.count", query = "select count(r.reviewId) from Review r")
})
public class Review {
    private int reviewId;
    private int rating;
    private String headline;
    private String comment;
    private Date reviewTime;
    private Book book;
    private Customer customer;

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
    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
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
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}