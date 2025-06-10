package com.renata.mycoursework.mapper;

import com.renata.mycoursework.controller.request.publications.PublicationsCreateRequest;
import com.renata.mycoursework.entity.Publications;

public interface PublicationsMapper {
    <T extends PublicationsCreateRequest> Publications requestMapToPublications(Publications publications, T request);
}
