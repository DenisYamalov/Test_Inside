package ru.inside.entity;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "test_inside")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", unique = true, nullable = false, length = 100)
    private String name;
    @Column(name = "password", nullable = false, length = 100)
    private String password;

}
