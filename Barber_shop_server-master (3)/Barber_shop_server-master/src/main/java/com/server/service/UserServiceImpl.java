package com.server.service;


import com.server.entity.User;
import com.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @PersistenceContext
    private EntityManager manager;

    public List<User> gettAll() {
        return userRepository.findAll();
    }

    public User getByID(Long id) {
        return userRepository.findOne(id);
    }

    public User save(User user) {
        return userRepository.saveAndFlush(user);
    }

    public void remove(Long id) {
        userRepository.delete(id);
    }

}
