package com.renata.mycoursework.service;

import com.renata.mycoursework.controller.request.outstandingPeople.OutstandingPeopleCreateRequest;
import com.renata.mycoursework.controller.request.outstandingPeople.OutstandingPeopleUpdateRequest;
import com.renata.mycoursework.entity.OutstandingPeople;

import java.util.List;
import java.util.Optional;

public interface OutstandingPeopleService {
    List<OutstandingPeople> findAll();
    Optional<OutstandingPeople> findById(Long id);
    OutstandingPeople create(OutstandingPeopleCreateRequest outstandingPeopleCreateRequest);
    OutstandingPeople update(OutstandingPeopleUpdateRequest outstandingPeopleUpdateRequest);
    void delete(Long id);
}
