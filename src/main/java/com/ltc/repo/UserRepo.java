package com.ltc.repo;

import com.ltc.model.User;

public interface UserRepo extends BaseRepository<User,Long>{
    User findByUserNameAndStatus(String username, Integer status);
}
