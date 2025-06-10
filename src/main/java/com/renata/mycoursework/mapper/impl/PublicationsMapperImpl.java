package com.renata.mycoursework.mapper.impl;

import com.renata.mycoursework.controller.request.publications.PublicationsCreateRequest;
import com.renata.mycoursework.entity.OutstandingPeople;
import com.renata.mycoursework.entity.Publications;
import com.renata.mycoursework.mapper.PublicationsMapper;
import com.renata.mycoursework.repository.OutstandingPeopleRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class PublicationsMapperImpl implements PublicationsMapper {

    private final OutstandingPeopleRepository outstandingPeopleRepository;

    public PublicationsMapperImpl(OutstandingPeopleRepository outstandingPeopleRepository){
        this.outstandingPeopleRepository = outstandingPeopleRepository;
    }
    @Override
    public <T extends PublicationsCreateRequest> Publications requestMapToPublications(Publications publications, T request) {
        if (request == null)
            return null;
        publications.setTitle(request.getTitle());
        publications.setYear(request.getYear());
        publications.setLink(request.getLink());

        Optional<OutstandingPeople> person = outstandingPeopleRepository.findById(request.getPersonId());
        if (person.isPresent())
            publications.setPerson(person.get());

        return publications;
    }
}
