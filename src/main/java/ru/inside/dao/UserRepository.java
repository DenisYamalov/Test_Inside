package ru.inside.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inside.entity.User;

/**
 * User repository to search in database
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Search User by name
     *
     * @param name
     * @return User or null
     */
    User findByName(String name);
}
