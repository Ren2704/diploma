package com.renata.mycoursework.service;

import com.renata.mycoursework.controller.request.personJob.PersonJobCreateRequest;
import com.renata.mycoursework.controller.request.personJob.PersonJobUpdateRequest;
import com.renata.mycoursework.entity.PersonJob;

import java.util.List;
import java.util.Optional;

public interface PersonJobService {
    List<PersonJob> findAll();
    Optional<PersonJob> findById(Long id);
    PersonJob create(PersonJobCreateRequest personJobCreateRequest);
    PersonJob update(PersonJobUpdateRequest personJobUpdateRequest);
    void delete(Long id);
}
