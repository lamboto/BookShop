package bookstore.service.impl;

import bookstore.repository.UserRepository;
import bookstore.service.UserValidationService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import bookstore.domain.entitites.User;

public class UserValidationServiceImpl implements UserValidationService {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;
    private final UserRepository userRepository;

    public UserValidationServiceImpl() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("book_shop");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.userRepository = new UserRepository(entityManager);
    }


    @Override
    public boolean canCreateUser(String email) {
        return isEmailValid(email);
    }

    private boolean isEmailValid(String email) {
        User user = this.userRepository.findUserByEmail(email);

        if (user == null) {
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);

            return matcher.find();
        } else {
            return false;
        }
    }
}
