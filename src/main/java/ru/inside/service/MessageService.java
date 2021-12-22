package ru.inside.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.inside.dao.MessageRepository;
import ru.inside.dao.UserRepository;
import ru.inside.dto.MessageDto;
import ru.inside.entity.Message;
import ru.inside.entity.User;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserService userService;

    public List<Message> findLast10 (String name){

        Page<Message> page = messageRepository.findAll(PageRequest.of(0,10,Sort.by(Sort.Direction.DESC,"time")));

        return messageRepository.findTop10ByUserNameOrderByIdDesc(name);
    }

    public Message saveMessage (MessageDto messageDto){
        Message message = new Message();
        message.setMessage(messageDto.getMessage());
        message.setUser(userService.findByName(messageDto.getName()));
        return messageRepository.save(message);
    }
}
