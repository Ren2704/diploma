package com.renata.mycoursework.mapper.impl;

import com.renata.mycoursework.controller.request.users.UsersCreateRequest;
import com.renata.mycoursework.entity.Users;
import com.renata.mycoursework.mapper.UsersMapper;
import com.renata.mycoursework.util.PasswordHasher;
import org.springframework.stereotype.Component;


@Component
public class UsersMapperImpl implements UsersMapper {
    @Override
    public <T extends UsersCreateRequest> Users requestMapToUsers(Users users, T request) {
        if (request == null)
            return null;
        users.setLogin(request.getLogin());
        users.setPassword(PasswordHasher.hashPassword(request.getPassword()));
        users.setRole(request.getRole());

        return users;
    }
}
