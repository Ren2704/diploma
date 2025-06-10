package com.renata.mycoursework.service;

import com.renata.mycoursework.controller.request.publications.PublicationsCreateRequest;
import com.renata.mycoursework.controller.request.publications.PublicationsUpdateRequest;
import com.renata.mycoursework.entity.Publications;

import java.util.List;
import java.util.Optional;

public interface PublicationsService {
    List<Publications> findAll();
    Optional<Publications> findById(Long id);
    Publications create(PublicationsCreateRequest publicationsCreateRequest);
    Publications update(PublicationsUpdateRequest publicationsUpdateRequest);
    void delete(Long id);
}
