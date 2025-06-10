package com.renata.mycoursework.service.impl;

import com.renata.mycoursework.controller.request.personJob.PersonJobCreateRequest;
import com.renata.mycoursework.controller.request.personJob.PersonJobUpdateRequest;
import com.renata.mycoursework.entity.PersonJob;
import com.renata.mycoursework.mapper.PersonJobMapper;
import com.renata.mycoursework.repository.PersonJobRepository;
import com.renata.mycoursework.service.PersonJobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonJobServiceImpl implements PersonJobService {
    private final PersonJobRepository personJobRepository; private final PersonJobMapper personJobMapper;
    public PersonJobServiceImpl(PersonJobRepository personJobRepository, PersonJobMapper personJobMapper) {
        this.personJobRepository = personJobRepository;
        this.personJobMapper = personJobMapper;
    }
    @Override
    public List<PersonJob> findAll() {
        return personJobRepository.findAll();
    }
    @Override
    public Optional<PersonJob> findById(Long id) {
        return personJobRepository.findById(id);
    }
    @Override
    public PersonJob create(PersonJobCreateRequest personJobCreateRequest) {
        PersonJob personJob = new PersonJob();
        personJob = personJobMapper.requestMapToPersonJob(personJob, personJobCreateRequest);
        return personJobRepository.save(personJob);
    }
    @Override
    public PersonJob update(PersonJobUpdateRequest personJobUpdateRequest) {
        Optional<PersonJob> optionalPersonJob = personJobRepository.findById(personJobUpdateRequest.getId());
        if (optionalPersonJob.isPresent()) {
            PersonJob personJob = optionalPersonJob.get();
            personJob = personJobMapper.requestMapToPersonJob(personJob, personJobUpdateRequest);
            return personJobRepository.save(personJob);
        }
        return null;
    }
    @Override
    public void delete(Long id) {
        personJobRepository.deleteById(id);
    }
}
