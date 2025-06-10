package com.renata.mycoursework.controller.request.outstandingPeople;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutstandingPeopleUpdateRequest extends OutstandingPeopleCreateRequest {
    private Long id;
}
