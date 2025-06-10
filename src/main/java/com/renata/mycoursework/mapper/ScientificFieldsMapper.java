package com.renata.mycoursework.mapper;

import com.renata.mycoursework.controller.request.scientificFields.ScientificFieldsCreateRequest;
import com.renata.mycoursework.entity.ScientificFields;

public interface ScientificFieldsMapper {
    <T extends ScientificFieldsCreateRequest> ScientificFields requestMapToScientificFields(ScientificFields scientificFields, T request);
}
