package com.elmirbek.taskflow.controller;


import com.elmirbek.taskflow.entity.User;
import com.elmirbek.taskflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers (){
        return userService.getAllUsers();
    }
}
