package com.renata.mycoursework.controller.request.users;

import com.renata.mycoursework.entity.enums.Role;
import lombok.Data;

@Data
public class UsersCreateRequest {
    private String login;
    private String password;
    private Role role = Role.NOT_SELECTED;
}
