package com.swathiprasad.springboot3virtualthreads.controller;

import com.swathiprasad.springboot3virtualthreads.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updateUsers() {
        userService.updateUsers();
    }
}
