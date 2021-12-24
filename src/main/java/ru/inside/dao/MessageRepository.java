package ru.inside.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inside.entity.Message;

import java.util.List;

/**
 * Message repository to search in database
 */
public interface MessageRepository extends JpaRepository<Message, Integer> {

    /**
     * Custom method to search last 10 messages by username
     *
     * @param name
     * @return message list ordered by time
     */
    List<Message> findTop10ByUserNameOrderByTimeDesc(String name);
}
