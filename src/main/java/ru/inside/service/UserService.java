package ru.inside.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.inside.dao.UserRepository;
import ru.inside.entity.User;

/**
 * Service for working with users
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Saves user to db
     *
     * @param user to be saved
     * @return saved user
     */
    public User saveUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    /**
     * Search user by name in database
     *
     * @param name
     * @return found user or null
     */
    public User findByName(String name) {

        return userRepository.findByName(name);
    }

    /**
     * Method to validate password for username
     *
     * @param name
     * @param password
     * @return User or null if password is wrong or no such user found
     */
    public User findByNameAndPassword(String name, String password) {

        User user = userRepository.findByName(name);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
