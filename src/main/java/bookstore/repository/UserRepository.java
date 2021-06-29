package bookstore.repository;

import bookstore.domain.entitites.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class UserRepository extends JpaRepository<User> implements GenericRepository<User> {


    public UserRepository(EntityManager entityManager) {
        super(entityManager);
    }


    @Override
    public User create(User entity) {
        return super.create(entity);
    }

    @Override
    public User update(User entity) {
        return super.update(entity);
    }

    @Override
    public User get(Object userId) {
        return super.get(User.class, userId);
    }

    @Override
    public void delete(Object id) {
        super.delete(User.class, id);
    }

    @Override
    public List<User> listAll() {
        return super.listAll("User.findAll");
    }


    @Override
    public long count() {
        return super.count("User.count");
    }

    public User findUserByEmail(String email) {
        List<User> listUsers = super.findWithNamedQuery("User.findByEmail", "email", email);
        if (listUsers != null && listUsers.size() > 0) {
            return listUsers.get(0);
        }
        return null;
    }
}
