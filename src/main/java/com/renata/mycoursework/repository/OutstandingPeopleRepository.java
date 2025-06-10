package com.renata.mycoursework.repository;

import com.renata.mycoursework.entity.OutstandingPeople;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OutstandingPeopleRepository extends JpaRepository<OutstandingPeople, Long> {
}
