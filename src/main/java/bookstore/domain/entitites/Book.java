package bookstore.domain.entitites;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "books", schema = "book_shop")
public class Book {
    private int bookId;
    private String title;
    private String author;
    private String description;
    private String isbn;
    private byte[] image;
    private double price;
    private Date publishDate;
    private Timestamp lastUpdateTime;
    private Category categoryByCategoryId;
    private Collection<OrdersDetail> ordersDetailByBookId;
    private Collection<Review> reviewByBookId;

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "isbn")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "publish_date")
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Basic
    @Column(name = "last_update_time")
    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId && Double.compare(book.price, price) == 0 && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(description, book.description) && Objects.equals(isbn, book.isbn) && Arrays.equals(image, book.image) && Objects.equals(publishDate, book.publishDate) && Objects.equals(lastUpdateTime, book.lastUpdateTime);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(bookId, title, author, description, isbn, price, publishDate, lastUpdateTime);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    public Category getCategoriesByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoriesByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }

    @OneToMany(mappedBy = "booksByBookId")
    public Collection<OrdersDetail> getOrdersDetailsByBookId() {
        return ordersDetailByBookId;
    }

    public void setOrdersDetailsByBookId(Collection<OrdersDetail> ordersDetailByBookId) {
        this.ordersDetailByBookId = ordersDetailByBookId;
    }

    @OneToMany(mappedBy = "booksByBookId")
    public Collection<Review> getReviewsByBookId() {
        return reviewByBookId;
    }

    public void setReviewsByBookId(Collection<Review> reviewByBookId) {
        this.reviewByBookId = reviewByBookId;
    }
}
