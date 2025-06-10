package com.renata.mycoursework.mapper;

import com.renata.mycoursework.controller.request.academicDegrees.AcademicDegreesCreateRequest;
import com.renata.mycoursework.entity.AcademicDegrees;

public interface AcademicDegreesMapper {
    <T extends AcademicDegreesCreateRequest> AcademicDegrees requestMapToAcademicDegrees(AcademicDegrees academicDegrees, T request);
}
