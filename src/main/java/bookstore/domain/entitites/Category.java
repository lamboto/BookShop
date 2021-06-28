package bookstore.domain.entitites;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "categories", schema = "book_shop")
public class Category {
    private int categoryId;
    private String name;
    private Collection<Book> bookByCategoryId;

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category that = (Category) o;
        return categoryId == that.categoryId && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, name);
    }

    @OneToMany(mappedBy = "categoriesByCategoryId")
    public Collection<Book> getBooksByCategoryId() {
        return bookByCategoryId;
    }

    public void setBooksByCategoryId(Collection<Book> bookByCategoryId) {
        this.bookByCategoryId = bookByCategoryId;
    }
}
