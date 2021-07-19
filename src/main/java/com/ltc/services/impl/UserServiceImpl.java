package com.ltc.services.impl;

import com.ltc.dto.UserDTO;
import com.ltc.model.Order;
import com.ltc.model.User;
import com.ltc.repo.RoleRepo;
import com.ltc.repo.UserRepo;
import com.ltc.services.UserService;
import com.ltc.utils.BaseMapper;
import com.ltc.utils.Const;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private RoleRepo roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private BaseMapper<User, UserDTO> mapper = new BaseMapper<>(User.class, UserDTO.class);

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findRoleByRoleName("USER")));
        user.setStatus(Const.STATUS.ACTIVCE);
        userRepository.save(user);
    }

    @Override
    public User findByUserNameAndStatus(String username, Integer status) {
        return userRepository.findByUserNameAndStatus(username, status);
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDTO> findAll(Boolean deleted) throws Exception {
        List<User> users = userRepository.findAllByDeleted(deleted);
        return mapper.toDtoBean(users);
    }

    @Override
    public void deleteUser(Long userId, String username) throws Exception {
        Date currentDate = new Date();
        User user = userRepository.findOne(userId);
        user.setDeleted(true);
        user.setCreatedBy(username);
        user.setCreatedDate(currentDate);
        userRepository.save(user);
    }

    @Override
    public UserDTO saveOrUpdate(UserDTO userDTO, String username, String roleName) throws Exception {
        boolean isCreate = userDTO.getId() == null ? true : false;
        Date currentDate = new Date();
        if (isCreate) {
            userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
            userDTO.setCreatedDate(currentDate);
            userDTO.setCreatedBy(username);
            userDTO.setDeleted(false);
            userDTO.setUpdatedBy(username);
            userDTO.setUpdatedDate(currentDate);
            userDTO.setStatus(Const.STATUS.ACTIVCE);
        } else {
            userDTO.setUpdatedBy(username);
            userDTO.setUpdatedDate(currentDate);
            userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        }
        User user = new User();
        user.setRoles(new HashSet<>(roleRepository.findRoleByRoleName(roleName)));

        BeanUtils.copyProperties(userDTO, user);

        userRepository.saveAndFlush(user);

        return userDTO;
    }
}