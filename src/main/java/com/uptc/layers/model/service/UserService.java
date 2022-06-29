package com.uptc.layers.model.service;

import java.util.List;

import com.uptc.layers.model.entity.User;
import com.uptc.layers.model.object.LoginCredentials;

public interface UserService {
    public List<User> findAll();
    public void create();
    public Boolean isValidUser(LoginCredentials loginCredentials);
    public User findOneByEmail(String email);
    public Boolean verifyUserWithEmailAndPassword(String email, String password);
}
