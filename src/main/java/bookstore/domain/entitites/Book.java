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
    private Set<OrdersDetail> ordersDetails;
    private Set<Review> reviews;
    private String base64Image;


    public Book() {
    }

    public Book(int bookId) {
        this.bookId = bookId;
    }

    @Id
    @Column(name = "book_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Transient
    public float getAverageRating() {
        float averageRating = 0.0f;
        float sum = 0.0f;

        if (reviews == null) {
            return 0.0f;
        }

        for (Review review : reviews) {
            sum += review.getRating();
        }

        averageRating = sum / this.reviews.size();

        // averageRating = (float) this.reviews.stream().mapToDouble(Review::getRating)
        //             .average().orElse(Double.NaN);

        return averageRating;
    }

    @Transient
    public String getRatingString(float averageRating) {
        String result = "";

        int numberOfStarsOn = (int) averageRating;

        for (int i = 1; i <= numberOfStarsOn; i++) {
            result += "on,";
        }
        int next = numberOfStarsOn + 1;

        if (averageRating > numberOfStarsOn) {
            result += "half,";
            next++;
        }

        for (int j = next; j <= 5; j++) {
            result += "off,";
        }


        return result.substring(0, result.length() - 1);
    }

    @Transient
    public String getRatingStars() {
        float averageRating = getAverageRating();

        return getRatingString(averageRating);
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
    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "author", nullable = false)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "isbn", nullable = false)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "image", nullable = false)
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
    @Column(name = "publish_date", nullable = false)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId == book.bookId && Double.compare(book.price, price) == 0 && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(description, book.description) && Objects.equals(isbn, book.isbn) && Arrays.equals(image, book.image) && Objects.equals(publishDate, book.publishDate) && Objects.equals(lastUpdateTime, book.lastUpdateTime) && Objects.equals(category, book.category) && Objects.equals(ordersDetails, book.ordersDetails) && Objects.equals(reviews, book.reviews) && Objects.equals(base64Image, book.base64Image);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(bookId, title, author, description, isbn, price, publishDate, lastUpdateTime, category, ordersDetails, reviews, base64Image);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    public Set<OrdersDetail> getOrdersDetails() {
        return ordersDetails;
    }

    public void setOrdersDetails(Set<OrdersDetail> ordersDetails) {
        this.ordersDetails = ordersDetails;
    }

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }
}
