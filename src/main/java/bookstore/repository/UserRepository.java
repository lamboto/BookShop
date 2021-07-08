package bookstore.repository;

import javax.persistence.EntityManager;

import bookstore.domain.entitites.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserRepository extends JpaRepository<User> implements GenericRepository<User> {


    public UserRepository() {
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

    public boolean checkLogin(String email, String password) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("email", email);
        parameters.put("password", password);
        List<User> listUsers = super.findWithNamedQuery("User.checkLogin", parameters);
        if (listUsers.size() == 1) {
            return true;
        }
        return false;
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
