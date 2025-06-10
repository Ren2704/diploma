package com.renata.mycoursework.service;

import com.renata.mycoursework.controller.request.academicTitles.AcademicTitlesCreateRequest;
import com.renata.mycoursework.controller.request.academicTitles.AcademicTitlesUpdateRequest;
import com.renata.mycoursework.entity.AcademicTitles;

import java.util.List;
import java.util.Optional;

public interface AcademicTitlesService {
    List<AcademicTitles> findAll();
    Optional<AcademicTitles> findById(Long id);
    AcademicTitles create(AcademicTitlesCreateRequest academicTitlesCreateRequest);
    AcademicTitles update(AcademicTitlesUpdateRequest academicTitlesUpdateRequest);
    void delete(Long id);
}
