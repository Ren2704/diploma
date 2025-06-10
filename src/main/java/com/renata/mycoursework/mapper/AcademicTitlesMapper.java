package com.renata.mycoursework.mapper;

import com.renata.mycoursework.controller.request.academicTitles.AcademicTitlesCreateRequest;
import com.renata.mycoursework.entity.AcademicTitles;

public interface AcademicTitlesMapper {
    <T extends AcademicTitlesCreateRequest> AcademicTitles requestMapToAcademicTitles(AcademicTitles academicTitles, T request);
}
