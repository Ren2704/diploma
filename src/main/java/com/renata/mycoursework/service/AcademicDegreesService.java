package com.renata.mycoursework.service;

import com.renata.mycoursework.controller.request.academicDegrees.AcademicDegreesCreateRequest;
import com.renata.mycoursework.controller.request.academicDegrees.AcademicDegreesUpdateRequest;
import com.renata.mycoursework.entity.AcademicDegrees;

import java.util.List;
import java.util.Optional;

public interface AcademicDegreesService {
    List<AcademicDegrees> findAll();
    Optional<AcademicDegrees> findById(Long id);
    AcademicDegrees create(AcademicDegreesCreateRequest academicDegreesCreateRequest);
    AcademicDegrees update(AcademicDegreesUpdateRequest academicDegreesUpdateRequest);
    void delete(Long id);
}
