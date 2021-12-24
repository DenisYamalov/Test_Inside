package ru.inside.dto;

public class MessageDto {

    private String name;
    private String message;

    public String getName() {

        return name;
    }

    public MessageDto setName(String name) {

        this.name = name;
        return this;
    }

    public String getMessage() {

        return message;
    }

    public MessageDto setMessage(String message) {

        this.message = message;
        return this;
    }
}
