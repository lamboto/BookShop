package bookstore.repository;

import bookstore.entitites.User;

import javax.persistence.EntityManager;


public class UserRepository extends JpaRepository<User> implements GenericRepository<User> {


    public UserRepository(EntityManager entityManager) {
        super(entityManager);
    }

    public User create(User user) {
        return super.create(user);
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public long count() {
        return 0;
    }
}
