package com.renata.mycoursework.controller.request.scientificFields;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScientificFieldsUpdateRequest extends ScientificFieldsCreateRequest {
    private Long id;
}
