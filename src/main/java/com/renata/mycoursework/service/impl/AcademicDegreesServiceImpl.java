package com.renata.mycoursework.service.impl;

import com.renata.mycoursework.controller.request.academicDegrees.AcademicDegreesCreateRequest;
import com.renata.mycoursework.controller.request.academicDegrees.AcademicDegreesUpdateRequest;
import com.renata.mycoursework.entity.AcademicDegrees;
import com.renata.mycoursework.mapper.AcademicDegreesMapper;
import com.renata.mycoursework.repository.AcademicDegreesRepository;
import com.renata.mycoursework.service.AcademicDegreesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicDegreesServiceImpl implements AcademicDegreesService {

    private final AcademicDegreesRepository academicDegreesRepository;
    private final AcademicDegreesMapper academicDegreesMapper;

    public AcademicDegreesServiceImpl(AcademicDegreesRepository academicDegreesRepository, AcademicDegreesMapper academicDegreesMapper) {
        this.academicDegreesRepository = academicDegreesRepository;
        this.academicDegreesMapper = academicDegreesMapper;
    }

    @Override
    public List<AcademicDegrees> findAll() {
        return academicDegreesRepository.findAll();
    }

    @Override
    public Optional<AcademicDegrees> findById(Long id) {
        return academicDegreesRepository.findById(id);
    }

    @Override
    public AcademicDegrees create(AcademicDegreesCreateRequest academicDegreesCreateRequest) {
        AcademicDegrees academicDegrees = new AcademicDegrees();
        academicDegrees = academicDegreesMapper.requestMapToAcademicDegrees(academicDegrees, academicDegreesCreateRequest);
        return academicDegreesRepository.save(academicDegrees);
    }

    @Override
    public AcademicDegrees update(AcademicDegreesUpdateRequest academicDegreesUpdateRequest) {
        Optional<AcademicDegrees> optionalAcademicDegrees = academicDegreesRepository.findById(academicDegreesUpdateRequest.getId());
        if (optionalAcademicDegrees.isPresent()) {
            AcademicDegrees academicDegrees = optionalAcademicDegrees.get();
            academicDegrees = academicDegreesMapper.requestMapToAcademicDegrees(academicDegrees, academicDegreesUpdateRequest);
            return academicDegreesRepository.save(academicDegrees);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        academicDegreesRepository.deleteById(id);
    }
}
