package bookstore.domain.servicemodels;

import bookstore.domain.entitites.BookOrder;
import bookstore.domain.entitites.Review;

import java.sql.Timestamp;
import java.util.Collection;

public class CustomerServiceModel {

    private int customerId;
    private String email;
    private String fullName;
    private String address;
    private String city;
    private String country;
    private String phone;
    private String zipcode;
    private String password;
    private Timestamp registerDate;
    private Collection<BookOrder> bookOrderByCustomerId;
    private Collection<Review> reviews;

    public CustomerServiceModel() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    public Collection<BookOrder> getBookOrderByCustomerId() {
        return bookOrderByCustomerId;
    }

    public void setBookOrderByCustomerId(Collection<BookOrder> bookOrderByCustomerId) {
        this.bookOrderByCustomerId = bookOrderByCustomerId;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<Review> reviews) {
        this.reviews = reviews;
    }
}
