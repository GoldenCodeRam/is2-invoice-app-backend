package com.uptc.layers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uptc.layers.model.entity.User;
import com.uptc.layers.model.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserRestController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> index() {
        return userService.findAll();
    }
}
