package ru.inside.dto;

import javax.validation.constraints.NotEmpty;

public class AuthRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    @Override
    public String toString() {

        return "AuthRequest{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
