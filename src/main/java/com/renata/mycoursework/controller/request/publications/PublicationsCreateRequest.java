package com.renata.mycoursework.controller.request.publications;

import com.renata.mycoursework.entity.OutstandingPeople;
import lombok.Data;

@Data
public class PublicationsCreateRequest {
    private String title;
    private int year;
    private String link;

    // зависимости
    private Long personId;
}
