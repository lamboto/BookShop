package bookstore.domain.view;

import bookstore.domain.entitites.Review;
import bookstore.domain.servicemodels.CategoryServiceModel;
import bookstore.domain.servicemodels.ReviewServiceModel;

import javax.persistence.Transient;
import java.util.Date;
import java.util.Set;

public class ListAllBookViewModel {
    private int bookId;
    private String title;
    private String author;
    private String description;
    private String isbn;
    private byte[] image;
    private double price;
    private Date publishDate;
    private Date lastUpdateTime;
    private CategoryServiceModel category;
    private String base64Image;
    private Set<ReviewServiceModel> reviews;

    public ListAllBookViewModel() {
    }

    @Transient
    public float getAverageRating() {
        float averageRating = 0.0f;
        float sum = 0.0f;

        if (reviews == null) {
            return 0.0f;
        }

        for (ReviewServiceModel review : reviews) {
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

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public CategoryServiceModel getCategory() {
        return category;
    }

    public void setCategory(CategoryServiceModel category) {
        this.category = category;
    }

    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }

    public Set<ReviewServiceModel> getReviews() {
        return reviews;
    }

    public void setReviews(Set<ReviewServiceModel> reviews) {
        this.reviews = reviews;
    }
}
