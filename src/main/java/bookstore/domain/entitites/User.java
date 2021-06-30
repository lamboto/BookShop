package bookstore.domain.entitites;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "select u from User u"),
        @NamedQuery(name = "User.count",query = "select count(u.userId) from User u"),
        @NamedQuery(name = "User.findByEmail", query = "select u from User u where u.email = :email")
})
public class User{
    private int userId;
    private String email;
    private String fullName;
    private String password;

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "full_name", nullable = false, length = 30)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 16)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(email, user.email) && Objects.equals(fullName, user.fullName) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, fullName, password);
    }
}
