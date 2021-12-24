package ru.inside.controller;

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

/**
 * Controller to test connection and receive user messages
 */
@RestController
public class TestController {

    public static final String HISTORY = "history 10";

    @Autowired
    private MessageService messageService;

    /**
     * Endpoint to test connection
     *
     * @return
     */
    @GetMapping("/user/hello")
    public String getUser() {

        return "Hi user";
    }

    /**
     * Endpoint to receive user messages
     *
     * @param messageDto dto - message from user to parse JSON
     * @return Message list with received message. If message text equals "history 10" returns user's last 10 messages
     */
    @PostMapping("/user/say")
    public List<MessageDto> say(@RequestBody MessageDto messageDto) {

        List<Message> messages = new ArrayList<>();
        if (messageDto.getMessage().equals(HISTORY)) {
            messages.addAll(messageService.findLast10(messageDto.getName()));
        } else {
            messages.add(messageService.saveMessage(messageDto));
        }
        return messages.stream()
                .map((m) -> new MessageDto().setName(m.getUser().getName()).setMessage(m.getMessage()))
                .collect(Collectors.toList());
    }
}
