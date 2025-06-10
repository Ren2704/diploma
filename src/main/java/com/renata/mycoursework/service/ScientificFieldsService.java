package com.renata.mycoursework.service;

import com.renata.mycoursework.controller.request.scientificFields.ScientificFieldsCreateRequest;
import com.renata.mycoursework.controller.request.scientificFields.ScientificFieldsUpdateRequest;
import com.renata.mycoursework.entity.ScientificFields;

import java.util.List;
import java.util.Optional;

public interface ScientificFieldsService {
    List<ScientificFields> findAll();
    Optional<ScientificFields> findById(Long id);
    ScientificFields create(ScientificFieldsCreateRequest scientificFieldsCreateRequest);
    ScientificFields update(ScientificFieldsUpdateRequest scientificFieldsUpdateRequest);
    void delete(Long id);
}
