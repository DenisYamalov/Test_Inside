package ru.inside.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.inside.dto.MessageDto;
import ru.inside.entity.Message;
import ru.inside.service.MessageService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TestController {
    public static final Logger log = LoggerFactory.getLogger(TestController.class);
    public static final String HISTORY = "history 10";

    @Autowired
    private MessageService messageService;

    @GetMapping("/user/hello")
    public String getUser() {
        return "Hi user";
    }

    @PostMapping("/user/say")
    public List<MessageDto> say(@RequestBody MessageDto messageDto){
        List<Message> messages = new ArrayList<>();
        if (messageDto.getMessage().equals(HISTORY)){
            messages.addAll(messageService.findLast10(messageDto.getName()));
        } else {
            messages.add(messageService.saveMessage(messageDto));
        }
        return messages.stream()
                .map((m)->new MessageDto().setName(m.getUser().getName()).setMessage(m.getMessage()))
                .collect(Collectors.toList());
    }
}
