package com.ltc.services.impl;

import com.ltc.dto.MyUser;
import com.ltc.model.Role;
import com.ltc.model.User;
import com.ltc.repo.UserRepo;
import com.ltc.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        User userEntity = userRepository.findByUserNameAndStatus(username, Const.STATUS.ACTIVCE);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : userEntity.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        MyUser myUser = new MyUser(userEntity.getUsername(), userEntity.getPassword(),
                true, true, true, true, authorities);
        myUser.setFullName(userEntity.getFullName());
        return myUser;
    }
}

