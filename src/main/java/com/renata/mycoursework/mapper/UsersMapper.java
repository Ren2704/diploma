package com.renata.mycoursework.mapper;

import com.renata.mycoursework.controller.request.users.UsersCreateRequest;
import com.renata.mycoursework.entity.Users;

public interface UsersMapper {
    <T extends UsersCreateRequest> Users requestMapToUsers(Users users, T request);
}
