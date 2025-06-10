package com.renata.mycoursework.mapper.impl;

import com.renata.mycoursework.controller.request.scientificFields.ScientificFieldsCreateRequest;
import com.renata.mycoursework.entity.ScientificFields;
import com.renata.mycoursework.mapper.ScientificFieldsMapper;
import org.springframework.stereotype.Component;


@Component
public class ScientificFieldsMapperImpl implements ScientificFieldsMapper {
    @Override
    public <T extends ScientificFieldsCreateRequest> ScientificFields requestMapToScientificFields(ScientificFields scientificFields, T request) {
        if (request == null)
            return null;
        scientificFields.setName(request.getName());
        scientificFields.setShortName(request.getShortName());

        return scientificFields;
    }
}
