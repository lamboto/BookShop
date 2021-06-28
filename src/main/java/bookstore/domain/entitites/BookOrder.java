package bookstore.domain.entitites;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "book_orders", schema = "book_shop")
public class BookOrder {
    private int orderId;
    private Timestamp orderDate;
    private String shippingAddress;
    private String recipientName;
    private String recipientPhone;
    private String paymentMethod;
    private double total;
    private String status;
    private Customer customerByCustomerId;
    private Collection<OrdersDetail> ordersDetailByOrderId;

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
    @Column(name = "order_date")
    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "shipping_address")
    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Basic
    @Column(name = "recipient_name")
    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    @Basic
    @Column(name = "recipient_phone")
    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    @Basic
    @Column(name = "payment_method")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Basic
    @Column(name = "total")
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookOrder that = (BookOrder) o;
        return orderId == that.orderId && Double.compare(that.total, total) == 0 && Objects.equals(orderDate, that.orderDate) && Objects.equals(shippingAddress, that.shippingAddress) && Objects.equals(recipientName, that.recipientName) && Objects.equals(recipientPhone, that.recipientPhone) && Objects.equals(paymentMethod, that.paymentMethod) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderDate, shippingAddress, recipientName, recipientPhone, paymentMethod, total, status);
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    public Customer getCustomersByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomersByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    @OneToMany(mappedBy = "bookOrdersByOrderId")
    public Collection<OrdersDetail> getOrdersDetailsByOrderId() {
        return ordersDetailByOrderId;
    }

    public void setOrdersDetailsByOrderId(Collection<OrdersDetail> ordersDetailByOrderId) {
        this.ordersDetailByOrderId = ordersDetailByOrderId;
    }
}
