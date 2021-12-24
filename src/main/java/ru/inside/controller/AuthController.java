package ru.inside.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.inside.Exceptions.SecurityException;
import ru.inside.config.jwt.JwtProvider;
import ru.inside.dto.AuthRequest;
import ru.inside.dto.AuthResponse;
import ru.inside.entity.User;
import ru.inside.service.UserService;

import javax.validation.Valid;

/**
 * Authentication controller
 */
@RestController
public class AuthController {

    public static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    /**
     * Endpoint to register new User
     *
     * @param request dto to parse from JSON
     * @return Ok if user created
     */
    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid AuthRequest request) {

        User user = new User();
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        userService.saveUser(user);
        return "OK";
    }

    /**
     * Endpoint to authenticate User
     *
     * @param request dto to parse from JSON
     * @return token
     * @throws SecurityException if no such user found in database or the password is wrong
     */
    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) throws SecurityException {

        User user = userService.findByNameAndPassword(request.getName(), request.getPassword());
        log.info("!!!! Here is USER" + user);
        if (user == null) {
            throw new SecurityException("Wrong name or password");
        }
        String token = jwtProvider.generateToken(user.getName());
        return new AuthResponse(token);
    }
}
