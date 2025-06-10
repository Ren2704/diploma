package com.renata.mycoursework.mapper.impl;

import com.renata.mycoursework.controller.request.outstandingPeople.OutstandingPeopleCreateRequest;
import com.renata.mycoursework.entity.AcademicDegrees;
import com.renata.mycoursework.entity.AcademicTitles;
import com.renata.mycoursework.entity.OutstandingPeople;
import com.renata.mycoursework.entity.ScientificFields;
import com.renata.mycoursework.mapper.OutstandingPeopleMapper;
import com.renata.mycoursework.repository.AcademicDegreesRepository;
import com.renata.mycoursework.repository.AcademicTitlesRepository;
import com.renata.mycoursework.repository.ScientificFieldsRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class OutstandingPeopleMapperImpl implements OutstandingPeopleMapper {

    private final AcademicTitlesRepository academicTitlesRepository;
    private final AcademicDegreesRepository academicDegreesRepository;
    private final ScientificFieldsRepository scientificFieldsRepository;

    public OutstandingPeopleMapperImpl(AcademicTitlesRepository academicTitlesRepository, AcademicDegreesRepository academicDegreesRepository, ScientificFieldsRepository scientificFieldsRepository){
        this.academicTitlesRepository = academicTitlesRepository;
        this.academicDegreesRepository = academicDegreesRepository;
        this.scientificFieldsRepository = scientificFieldsRepository;
    }
    @Override
    public <T extends OutstandingPeopleCreateRequest> OutstandingPeople requestMapToOutstandingPeople(OutstandingPeople person, T request) {
        if (request == null)
            return null;
        person.setName(request.getName());
        person.setSurname(request.getSurname());
        person.setPatronymic(request.getPatronymic());
        person.setGender(request.getGender());
        person.setYearOfBirth(request.getYearOfBirth());
        person.setYearOfDeath(request.getYearOfDeath());
        person.setPhotoUrl(person.getPhotoUrl());
        person.setBiography(request.getBiography());

        Optional<AcademicTitles> academicTitles = academicTitlesRepository.findByName(request.getAcademicTitles());
        if (academicTitles.isPresent())
            person.setAcademicTitles(academicTitles.get());

        Optional<AcademicDegrees> academicDegrees = academicDegreesRepository.findByName(request.getAcademicDegrees());
        if (academicDegrees.isPresent())
            person.setAcademicDegrees(academicDegrees.get());

        Optional<ScientificFields> scientificFields = scientificFieldsRepository.findByName(request.getScientificFields());
        if (scientificFields.isPresent())
            person.setScientificFields(scientificFields.get());

        return person;
    }
}
