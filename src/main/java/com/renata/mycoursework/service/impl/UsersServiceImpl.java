package com.renata.mycoursework.service.impl;

import com.renata.mycoursework.controller.request.users.UsersCreateRequest;
import com.renata.mycoursework.controller.request.users.UsersUpdateRequest;
import com.renata.mycoursework.entity.Users;
import com.renata.mycoursework.mapper.UsersMapper;
import com.renata.mycoursework.repository.UsersRepository;
import com.renata.mycoursework.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;

    public UsersServiceImpl(UsersRepository usersRepository, UsersMapper usersMapper) {
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public Users create(UsersCreateRequest usersCreateRequest) {
        Users users = new Users();
        users = usersMapper.requestMapToUsers(users, usersCreateRequest);
        return usersRepository.save(users);
    }

    @Override
    public Users update(UsersUpdateRequest usersUpdateRequest) {
        Optional<Users> optionalUsers = usersRepository.findById(usersUpdateRequest.getId());
        if (optionalUsers.isPresent()) {
            Users users = optionalUsers.get();
            users = usersMapper.requestMapToUsers(users, usersUpdateRequest);
            return usersRepository.save(users);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        usersRepository.deleteById(id);
    }
}
