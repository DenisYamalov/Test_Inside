package ru.inside.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Message entity
 */
@Entity
@Table(name = "messages", schema = "test_inside")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "time", nullable = false)
    private Date time = new Date();

    public Message() {

    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    @Override
    public String toString() {

        return "Message{" +
                "id=" + id +
                ", user=" + user +
                ", message='" + message + '\'' +
                '}';
    }
}
