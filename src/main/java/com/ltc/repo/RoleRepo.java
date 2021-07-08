package com.ltc.repo;

import com.ltc.model.Role;

import java.util.HashSet;

public interface RoleRepo extends BaseRepository<Role,Long>{
    HashSet findRoleByRoleName(String roleName);
}
