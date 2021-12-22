package ru.inside.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.inside.config.jwt.JwtProvider;
import ru.inside.dto.AuthResponse;
import ru.inside.dto.AuthRequest;
import ru.inside.entity.User;
import ru.inside.service.UserService;

import javax.validation.Valid;

@RestController
public class AuthController {

    public static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String registerUser (@RequestBody @Valid AuthRequest request){

        User user = new User();
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        userService.saveUser(user);
        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request){

        User user = userService.findByNameAndPassword(request.getName(),request.getPassword());
        String token = jwtProvider.generateToken(user.getName());
        return new AuthResponse(token);
    }
}
