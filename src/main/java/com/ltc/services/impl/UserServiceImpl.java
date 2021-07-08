package com.ltc.services.impl;

import com.ltc.model.User;
import com.ltc.repo.RoleRepo;
import com.ltc.repo.UserRepo;
import com.ltc.services.UserService;
import com.ltc.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private RoleRepo roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findRoleByRoleName("USER")));
        user.setStatus(Const.STATUS.ACTIVCE);
        userRepository.save(user);
    }

    @Override
    public User findByUserNameAndStatus(String username, Integer status) {
        return userRepository.findByUserNameAndStatus(username,status);
    }
}