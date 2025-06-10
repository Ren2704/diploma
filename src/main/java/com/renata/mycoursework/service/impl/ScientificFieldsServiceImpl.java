package com.renata.mycoursework.service.impl;

import com.renata.mycoursework.controller.request.scientificFields.ScientificFieldsCreateRequest;
import com.renata.mycoursework.controller.request.scientificFields.ScientificFieldsUpdateRequest;
import com.renata.mycoursework.entity.ScientificFields;
import com.renata.mycoursework.mapper.ScientificFieldsMapper;
import com.renata.mycoursework.repository.ScientificFieldsRepository;
import com.renata.mycoursework.service.ScientificFieldsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScientificFieldsServiceImpl implements ScientificFieldsService {

    private final ScientificFieldsRepository scientificFieldsRepository;
    private final ScientificFieldsMapper scientificFieldsMapper;

    public ScientificFieldsServiceImpl(ScientificFieldsRepository scientificFieldsRepository, ScientificFieldsMapper scientificFieldsMapper) {
        this.scientificFieldsRepository = scientificFieldsRepository;
        this.scientificFieldsMapper = scientificFieldsMapper;
    }

    @Override
    public List<ScientificFields> findAll() {
        return scientificFieldsRepository.findAll();
    }

    @Override
    public Optional<ScientificFields> findById(Long id) {
        return scientificFieldsRepository.findById(id);
    }

    @Override
    public ScientificFields create(ScientificFieldsCreateRequest scientificFieldsCreateRequest) {
        ScientificFields scientificFields = new ScientificFields();
        scientificFields = scientificFieldsMapper.requestMapToScientificFields(scientificFields, scientificFieldsCreateRequest);
        return scientificFieldsRepository.save(scientificFields);
    }

    @Override
    public ScientificFields update(ScientificFieldsUpdateRequest scientificFieldsUpdateRequest) {
        Optional<ScientificFields> optionalScientificFields = scientificFieldsRepository.findById(scientificFieldsUpdateRequest.getId());
        if (optionalScientificFields.isPresent()) {
            ScientificFields scientificFields = optionalScientificFields.get();
            scientificFields = scientificFieldsMapper.requestMapToScientificFields(scientificFields, scientificFieldsUpdateRequest);
            return scientificFieldsRepository.save(scientificFields);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        scientificFieldsRepository.deleteById(id);
    }
}
