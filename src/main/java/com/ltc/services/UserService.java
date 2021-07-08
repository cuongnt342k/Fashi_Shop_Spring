package com.ltc.services;

import com.ltc.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUserNameAndStatus(String username, Integer status);
}
