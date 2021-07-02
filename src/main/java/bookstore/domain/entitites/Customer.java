package bookstore.domain.entitites;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "customers", schema = "book_shop")
public class Customer {
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

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "zipcode")
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "register_date")
    public Timestamp getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Timestamp registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && Objects.equals(email, customer.email) && Objects.equals(fullName, customer.fullName) && Objects.equals(address, customer.address) && Objects.equals(city, customer.city) && Objects.equals(country, customer.country) && Objects.equals(phone, customer.phone) && Objects.equals(zipcode, customer.zipcode) && Objects.equals(password, customer.password) && Objects.equals(registerDate, customer.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, email, fullName, address, city, country, phone, zipcode, password, registerDate);
    }

    @OneToMany(mappedBy = "customersByCustomerId")
    public Collection<BookOrder> getBookOrdersByCustomerId() {
        return bookOrderByCustomerId;
    }

    public void setBookOrdersByCustomerId(Collection<BookOrder> bookOrderByCustomerId) {
        this.bookOrderByCustomerId = bookOrderByCustomerId;
    }

    @OneToMany(mappedBy = "customer")
    public Collection<Review> getReviewsByCustomerId() {
        return reviews;
    }

    public void setReviewsByCustomerId(Collection<Review> reviewByCustomerId) {
        this.reviews = reviewByCustomerId;
    }
}
