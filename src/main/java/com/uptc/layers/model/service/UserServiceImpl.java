package com.uptc.layers.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uptc.layers.model.entity.User;
import com.uptc.layers.model.entity.UserDAO;
import com.uptc.layers.model.object.LoginCredentials;
import com.uptc.layers.security.Hash;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO dao;

    @Override
    public List<User> findAll() {
        return (List<User>) dao.findAll();
    }

    @Override
    public User findOneByEmail(String email) {
        User[] foundUser = new User[] { null };
        findAll().forEach(user -> {
            if (user.getEmail().contentEquals(email)) {
                foundUser[0] = user;
                return;
            }
        });
        return foundUser[0];
    }

    @Override
    public Boolean verifyUserWithEmailAndPassword(String email, String password) {
        User foundUser = this.findOneByEmail(email);
        return foundUser.getPassword().equals(Hash.generateStringHash(password));
    }

    @Override
    public void create() {
    }

    @Override
    public Boolean isValidUser(LoginCredentials loginCredentials) {
        return true;
    }
}