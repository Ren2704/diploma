package com.renata.mycoursework.controller.request.personJob;

import lombok.Data;

@Data
public class PersonJobCreateRequest {
    private int startYear;
    private int endYear;
    private boolean isCurrent = false;

    // зависимости
    private Long personId;
    private String jobTitle;
}
