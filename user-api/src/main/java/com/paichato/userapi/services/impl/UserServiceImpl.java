package com.paichato.userapi.services.impl;

import com.paichato.userapi.domain.User;
import com.paichato.userapi.repositories.UserRepository;
import com.paichato.userapi.services.UserService;
import com.paichato.userapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    private final Environment env;

    @Override
    public User findById(Long id) {
        log.info("USER_SERVICE ::: GET REQUEST on " + env.getProperty("local.server.port")+ "port");

        return repository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Object Not found"));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}
