package com.renata.mycoursework.mapper.impl;

import com.renata.mycoursework.controller.request.personJob.PersonJobCreateRequest;
import com.renata.mycoursework.entity.JobTitle;
import com.renata.mycoursework.entity.OutstandingPeople;
import com.renata.mycoursework.entity.PersonJob;
import com.renata.mycoursework.mapper.PersonJobMapper;
import com.renata.mycoursework.repository.JobTitleRepository;
import com.renata.mycoursework.repository.OutstandingPeopleRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class PersonJobMapperImpl implements PersonJobMapper {
    private final OutstandingPeopleRepository outstandingPeopleRepository;
    private final JobTitleRepository jobTitleRepository;
    public PersonJobMapperImpl(OutstandingPeopleRepository outstandingPeopleRepository, JobTitleRepository jobTitleRepository){
        this.outstandingPeopleRepository = outstandingPeopleRepository;
        this.jobTitleRepository = jobTitleRepository;
    }
    @Override
    public <T extends PersonJobCreateRequest> PersonJob requestMapToPersonJob(PersonJob personJob, T request) {
        if (request == null)
            return null;
        personJob.setStartYear(request.getStartYear());
        personJob.setEndYear(request.getEndYear());
        personJob.setCurrent(request.isCurrent());
        Optional<OutstandingPeople> person = outstandingPeopleRepository.findById(request.getPersonId());
        if (person.isPresent())
            personJob.setPerson(person.get());
        Optional<JobTitle> jobTitle = jobTitleRepository.findByName(request.getJobTitle());
        if (jobTitle.isPresent())
            personJob.setJobTitle(jobTitle.get());
        return personJob;
    }
}
