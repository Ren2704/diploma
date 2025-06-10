package com.renata.mycoursework.mapper;

import com.renata.mycoursework.controller.request.outstandingPeople.OutstandingPeopleCreateRequest;
import com.renata.mycoursework.entity.OutstandingPeople;

public interface OutstandingPeopleMapper {
    <T extends OutstandingPeopleCreateRequest> OutstandingPeople requestMapToOutstandingPeople(OutstandingPeople person, T request);
}
