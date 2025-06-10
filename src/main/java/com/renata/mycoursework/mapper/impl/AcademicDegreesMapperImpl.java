package com.renata.mycoursework.mapper.impl;

import com.renata.mycoursework.controller.request.academicDegrees.AcademicDegreesCreateRequest;
import com.renata.mycoursework.entity.AcademicDegrees;
import com.renata.mycoursework.mapper.AcademicDegreesMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class AcademicDegreesMapperImpl implements AcademicDegreesMapper {
    @Override
    public <T extends AcademicDegreesCreateRequest> AcademicDegrees requestMapToAcademicDegrees(AcademicDegrees academicDegrees, T request) {
        if (request == null)
            return null;
        academicDegrees.setName(request.getName());
        academicDegrees.setShortName(request.getShortName());

        return academicDegrees;
    }
}
