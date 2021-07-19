package com.ltc.services;

import com.ltc.dto.OrderDTO;
import com.ltc.dto.OrderProductDTO;
import com.ltc.dto.UserDTO;
import com.ltc.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUserNameAndStatus(String username, Integer status);

    User findByUserName(String username);

    User findByEmail(String email);

    List<UserDTO> findAll(Boolean deleted) throws Exception;

    public void deleteUser(Long userId, String username) throws Exception;

    public UserDTO saveOrUpdate(UserDTO userDTO, String username,String roleName) throws Exception;
}
