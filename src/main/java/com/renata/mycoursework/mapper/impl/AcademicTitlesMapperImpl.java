package com.renata.mycoursework.mapper.impl;

import com.renata.mycoursework.controller.request.academicTitles.AcademicTitlesCreateRequest;
import com.renata.mycoursework.entity.AcademicTitles;
import com.renata.mycoursework.mapper.AcademicTitlesMapper;
import org.springframework.stereotype.Component;


@Component
public class AcademicTitlesMapperImpl implements AcademicTitlesMapper {
    @Override
    public <T extends AcademicTitlesCreateRequest> AcademicTitles requestMapToAcademicTitles(AcademicTitles academicTitles, T request) {
        if (request == null)
            return null;
        academicTitles.setName(request.getName());
        academicTitles.setShortName(request.getShortName());

        return academicTitles;
    }
}
