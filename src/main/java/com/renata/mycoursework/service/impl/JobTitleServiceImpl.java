package com.renata.mycoursework.service.impl;

import com.renata.mycoursework.controller.request.jobTitle.JobTitleCreateRequest;
import com.renata.mycoursework.controller.request.jobTitle.JobTitleUpdateRequest;
import com.renata.mycoursework.entity.JobTitle;
import com.renata.mycoursework.mapper.JobTitleMapper;
import com.renata.mycoursework.repository.JobTitleRepository;
import com.renata.mycoursework.service.JobTitleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleServiceImpl implements JobTitleService {

    private final JobTitleRepository jobTitleRepository;
    private final JobTitleMapper jobTitleMapper;

    public JobTitleServiceImpl(JobTitleRepository jobTitleRepository, JobTitleMapper jobTitleMapper) {
        this.jobTitleRepository = jobTitleRepository;
        this.jobTitleMapper = jobTitleMapper;
    }

    @Override
    public List<JobTitle> findAll() {
        return jobTitleRepository.findAll();
    }

    @Override
    public Optional<JobTitle> findById(Long id) {
        return jobTitleRepository.findById(id);
    }

    @Override
    public JobTitle create(JobTitleCreateRequest jobTitleCreateRequest) {
        JobTitle jobTitle = new JobTitle();
        jobTitle = jobTitleMapper.requestMapToJobTitle(jobTitle, jobTitleCreateRequest);
        return jobTitleRepository.save(jobTitle);
    }

    @Override
    public JobTitle update(JobTitleUpdateRequest jobTitleUpdateRequest) {
        Optional<JobTitle> optionalJobTitle = jobTitleRepository.findById(jobTitleUpdateRequest.getId());
        if (optionalJobTitle.isPresent()) {
            JobTitle jobTitle = optionalJobTitle.get();
            jobTitle = jobTitleMapper.requestMapToJobTitle(jobTitle, jobTitleUpdateRequest);
            return jobTitleRepository.save(jobTitle);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        jobTitleRepository.deleteById(id);
    }
}
