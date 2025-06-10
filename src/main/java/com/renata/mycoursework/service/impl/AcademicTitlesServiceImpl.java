package com.renata.mycoursework.service.impl;

import com.renata.mycoursework.controller.request.academicTitles.AcademicTitlesCreateRequest;
import com.renata.mycoursework.controller.request.academicTitles.AcademicTitlesUpdateRequest;
import com.renata.mycoursework.entity.AcademicTitles;
import com.renata.mycoursework.mapper.AcademicTitlesMapper;
import com.renata.mycoursework.repository.AcademicTitlesRepository;
import com.renata.mycoursework.service.AcademicTitlesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicTitlesServiceImpl implements AcademicTitlesService {

    private final AcademicTitlesRepository academicTitlesRepository;
    private final AcademicTitlesMapper academicTitlesMapper;

    public AcademicTitlesServiceImpl(AcademicTitlesRepository academicTitlesRepository, AcademicTitlesMapper academicTitlesMapper) {
        this.academicTitlesRepository = academicTitlesRepository;
        this.academicTitlesMapper = academicTitlesMapper;
    }

    @Override
    public List<AcademicTitles> findAll() {
        return academicTitlesRepository.findAll();
    }

    @Override
    public Optional<AcademicTitles> findById(Long id) {
        return academicTitlesRepository.findById(id);
    }

    @Override
    public AcademicTitles create(AcademicTitlesCreateRequest academicTitlesCreateRequest) {
        AcademicTitles academicTitles = new AcademicTitles();
        academicTitles = academicTitlesMapper.requestMapToAcademicTitles(academicTitles, academicTitlesCreateRequest);
        return academicTitlesRepository.save(academicTitles);
    }

    @Override
    public AcademicTitles update(AcademicTitlesUpdateRequest academicTitlesUpdateRequest) {
        Optional<AcademicTitles> optionalAcademicTitles = academicTitlesRepository.findById(academicTitlesUpdateRequest.getId());
        if (optionalAcademicTitles.isPresent()) {
            AcademicTitles academicTitles = optionalAcademicTitles.get();
            academicTitles = academicTitlesMapper.requestMapToAcademicTitles(academicTitles, academicTitlesUpdateRequest);
            return academicTitlesRepository.save(academicTitles);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        academicTitlesRepository.deleteById(id);
    }
}
