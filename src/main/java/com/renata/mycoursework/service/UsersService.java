package com.renata.mycoursework.service;

import com.renata.mycoursework.controller.request.users.UsersCreateRequest;
import com.renata.mycoursework.controller.request.users.UsersUpdateRequest;
import com.renata.mycoursework.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<Users> findAll();
    Optional<Users> findById(Long id);
    Users create(UsersCreateRequest usersCreateRequest);
    Users update(UsersUpdateRequest usersUpdateRequest);
    void delete(Long id);
}
