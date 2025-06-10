package com.renata.mycoursework.repository;

import com.renata.mycoursework.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
