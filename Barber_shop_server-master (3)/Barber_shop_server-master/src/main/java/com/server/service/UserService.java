package com.server.service;


import com.server.entity.User;

import java.util.List;

public interface UserService {

    User getByID(Long id);
    User save(User user);
    void remove(Long id);
    List<User> gettAll();
}
