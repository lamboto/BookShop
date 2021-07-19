package bookstore.domain.entitites;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orders_details", schema = "book_shop")
public class OrdersDetail {

    private int orderId;
    private int quantity;
    private double subtotal;
    private BookOrder bookOrderByOrderId;
    private Book book;


    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "quantity",nullable = false)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "subtotal",nullable = false)
    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersDetail that = (OrdersDetail) o;
        return quantity == that.quantity && Double.compare(that.subtotal, subtotal) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, subtotal);
    }

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    public BookOrder getBookOrdersByOrderId() {
        return bookOrderByOrderId;
    }

    public void setBookOrdersByOrderId(BookOrder bookOrderByOrderId) {
        this.bookOrderByOrderId = bookOrderByOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    public Book getBook() {
        return book;
    }

    public void setBook(Book bookByBookId) {
        this.book = bookByBookId;
    }
}