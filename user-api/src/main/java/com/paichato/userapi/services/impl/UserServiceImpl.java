package com.paichato.userapi.services.impl;

import com.paichato.userapi.domain.User;
import com.paichato.userapi.repositories.UserRepository;
import com.paichato.userapi.services.UserService;
import com.paichato.userapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Object Not found"));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
