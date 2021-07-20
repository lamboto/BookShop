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
    private double rating;
    private String headline;
    private String comment;
    private Date reviewTime;
    private Book book;
    private Customer customer;

    @Id
    @Column(name = "review_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    @Transient
    public String getStars() {
        String result = "";

        int numberOfStarsOn = (int) rating;

        for (int i = 1; i <= numberOfStarsOn; i++) {
            result += "on,";
        }


        for (int j = numberOfStarsOn + 1; j <= 5; j++) {
            result += "off,";
        }


        return result.substring(0, result.length() - 1);
    }

    @Basic
    @Column(name = "rating", nullable = false)
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "headline", nullable = false)
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
    @Column(name = "review_time", nullable = false)
    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", nullable = false)
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}