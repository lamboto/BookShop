package bookstore.domain.entitites;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
import java.sql.Timestamp;


@Entity
@Table(name = "books", schema = "book_shop")
@NamedQueries({
        @NamedQuery(name = "Book.findByTitle", query = "select b from Book b where b.title = :title"),
        @NamedQuery(name = "Book.findAll", query = "select b from Book b order by b.title"),
        @NamedQuery(name = "Book.count", query = "select count(b.bookId) from Book b"),
        @NamedQuery(name = "Book.findByCategory", query = "select b from Book b where b.category.categoryId = :categoryId"),
        @NamedQuery(name = "Book.findByPublishDate", query = "select b from Book b order by b.publishDate desc "),
        @NamedQuery(name = "Book.findByKeyword", query = "select b from Book b where b.title like :keyword" +
                " or b.author like :keyword" +
                " or b.description like :keyword")
})
public class Book implements Serializable {
    private int bookId;
    private String title;
    private String author;
    private String description;
    private String isbn;
    private byte[] image;
    private double price;
    private Date publishDate;
    private Date lastUpdateTime;
    private Category category;
    private Set<BookOrder> bookOrders;
    private Set<Review> reviews;
    private String base64Image;

    public Book() {
    }

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Transient
    public String getBase64Image() {
        this.base64Image = Base64.getEncoder().encodeToString(this.image);
        return this.base64Image;
    }

    @Transient
    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
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
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToMany(mappedBy = "books")
    public Set<BookOrder> getBookOrders() {
        return bookOrders;
    }

    public void setBookOrders(Set<BookOrder> bookOrders) {
        this.bookOrders = bookOrders;
    }

    @OneToMany
    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
