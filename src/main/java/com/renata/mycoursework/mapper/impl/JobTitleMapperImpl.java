package com.renata.mycoursework.mapper.impl;

import com.renata.mycoursework.controller.request.jobTitle.JobTitleCreateRequest;
import com.renata.mycoursework.entity.JobTitle;
import com.renata.mycoursework.mapper.JobTitleMapper;
import org.springframework.stereotype.Component;


@Component
public class JobTitleMapperImpl implements JobTitleMapper {
    @Override
    public <T extends JobTitleCreateRequest> JobTitle requestMapToJobTitle(JobTitle jobTitle, T request) {
        if (request == null)
            return null;
        jobTitle.setName(request.getName());

        return jobTitle;
    }
}
