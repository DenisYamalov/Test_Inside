package ru.inside.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inside.entity.Message;

import java.awt.print.Pageable;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer> {
    List<Message> findAllByUserName(String name);


    List<Message> findTop10ByUserName(String name);

    List<Message> findTop10ByUserNameOrderByIdDesc(String name);
}
