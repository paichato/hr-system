package com.paichato.userapi.services;

import com.paichato.userapi.domain.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> findAll();
}
