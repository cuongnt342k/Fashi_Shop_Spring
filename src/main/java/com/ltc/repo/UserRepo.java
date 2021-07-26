package com.ltc.repo;

import com.ltc.model.User;

import java.util.List;

public interface UserRepo extends BaseRepository<User,Long>{
    User findByUserNameAndStatus(String username, Integer status);

    User findByUserName(String username);

    User findByEmail(String email);

    User findById(Long id);

    List<User> findAllByDeleted(Boolean deleted) throws Exception;
}
