package com.renata.mycoursework.service.impl;

import com.renata.mycoursework.controller.request.publications.PublicationsCreateRequest;
import com.renata.mycoursework.controller.request.publications.PublicationsUpdateRequest;
import com.renata.mycoursework.entity.Publications;
import com.renata.mycoursework.mapper.PublicationsMapper;
import com.renata.mycoursework.repository.PublicationsRepository;
import com.renata.mycoursework.service.PublicationsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationsServiceImpl implements PublicationsService {

    private final PublicationsRepository publicationsRepository;
    private final PublicationsMapper publicationsMapper;

    public PublicationsServiceImpl(PublicationsRepository publicationsRepository, PublicationsMapper publicationsMapper) {
        this.publicationsRepository = publicationsRepository;
        this.publicationsMapper = publicationsMapper;
    }

    @Override
    public List<Publications> findAll() {
        return publicationsRepository.findAll();
    }

    @Override
    public Optional<Publications> findById(Long id) {
        return publicationsRepository.findById(id);
    }

    @Override
    public Publications create(PublicationsCreateRequest publicationsCreateRequest) {
        Publications publications = new Publications();
        publications = publicationsMapper.requestMapToPublications(publications, publicationsCreateRequest);
        return publicationsRepository.save(publications);
    }

    @Override
    public Publications update(PublicationsUpdateRequest publicationsUpdateRequest) {
        Optional<Publications> optionalPublications = publicationsRepository.findById(publicationsUpdateRequest.getId());
        if (optionalPublications.isPresent()) {
            Publications publications = optionalPublications.get();
            publications = publicationsMapper.requestMapToPublications(publications, publicationsUpdateRequest);
            return publicationsRepository.save(publications);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        publicationsRepository.findById(id);
    }
}
