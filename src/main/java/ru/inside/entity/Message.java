package ru.inside.entity;

import javax.persistence.*;

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

    public User getUser() {

        return user;
    }
}
