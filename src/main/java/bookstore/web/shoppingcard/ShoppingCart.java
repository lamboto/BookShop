package bookstore.web.shoppingcard;

import bookstore.domain.entitites.Book;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShoppingCart {
    private Map<Book, Integer> cart;

    public ShoppingCart() {
        this.cart = new HashMap<>();
    }

    public void addItem(Book book) {
        if (!cart.containsKey(book)) {
            cart.put(book, 1);
        } else {
            cart.put(book, cart.get(book) + 1);
        }
    }

    public void removeItem(Book book) {
        cart.remove(book);
    }

    public Map<Book, Integer> getItems() {
        return this.cart;
    }

    public double getTotalAmount() {
        int total = 0;

        for (Book book : cart.keySet()) {
            int quantity = cart.get(book);
            double subtotal = quantity * book.getPrice();
            total += subtotal;
        }

        return total;
    }

    public int getTotalQuantity() {
        int total = 0;

        for (Book book : cart.keySet()) {
            total += cart.get(book);
        }

        return total;
    }

    public void clear() {
        this.cart.clear();
    }
}
