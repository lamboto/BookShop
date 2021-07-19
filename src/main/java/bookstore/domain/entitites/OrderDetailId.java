package bookstore.domain.entitites;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class OrderDetailId implements Serializable {
    private Book book;
    private BookOrder bookOrder;


    public OrderDetailId() {
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", insertable = false, updatable = false, nullable = false)
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", insertable = false, updatable = false, nullable = false)
    public BookOrder getBookOrder() {
        return bookOrder;
    }

    public void setBookOrder(BookOrder bookOrder) {
        this.bookOrder = bookOrder;
    }


}
