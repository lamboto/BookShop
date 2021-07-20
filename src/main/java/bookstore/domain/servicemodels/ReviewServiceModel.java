package bookstore.domain.servicemodels;

import bookstore.domain.entitites.Book;
import bookstore.domain.entitites.Customer;

import javax.persistence.Transient;
import java.util.Date;

public class ReviewServiceModel {
    private int reviewId;
    private double rating;
    private String headline;
    private String comment;
    private Date reviewTime;
    private BookServiceModel book;
    private CustomerServiceModel customer;

    public ReviewServiceModel() {
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

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    public BookServiceModel getBook() {
        return book;
    }

    public void setBook(BookServiceModel book) {
        this.book = book;
    }

    public CustomerServiceModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerServiceModel customer) {
        this.customer = customer;
    }
}
