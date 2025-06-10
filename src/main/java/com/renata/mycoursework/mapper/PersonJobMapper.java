package com.renata.mycoursework.mapper;

import com.renata.mycoursework.controller.request.personJob.PersonJobCreateRequest;
import com.renata.mycoursework.entity.PersonJob;

public interface PersonJobMapper {
    <T extends PersonJobCreateRequest> PersonJob requestMapToPersonJob(PersonJob personJob, T request);
}
