package com.renata.mycoursework.mapper;

import com.renata.mycoursework.controller.request.jobTitle.JobTitleCreateRequest;
import com.renata.mycoursework.entity.JobTitle;

public interface JobTitleMapper {
    <T extends JobTitleCreateRequest> JobTitle requestMapToJobTitle(JobTitle jobTitle, T request);
}
