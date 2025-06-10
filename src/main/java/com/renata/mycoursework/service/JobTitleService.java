package com.renata.mycoursework.service;

import com.renata.mycoursework.controller.request.jobTitle.JobTitleCreateRequest;
import com.renata.mycoursework.controller.request.jobTitle.JobTitleUpdateRequest;
import com.renata.mycoursework.entity.JobTitle;

import java.util.List;
import java.util.Optional;

public interface JobTitleService {
    List<JobTitle> findAll();
    Optional<JobTitle> findById(Long id);
    JobTitle create(JobTitleCreateRequest jobTitleCreateRequest);
    JobTitle update(JobTitleUpdateRequest jobTitleUpdateRequest);
    void delete(Long id);
}
