package com.renata.mycoursework.controller.request.achievements;

import com.renata.mycoursework.entity.OutstandingPeople;
import lombok.Data;

@Data
public class AchievementsCreateRequest {
    private String title;
    private int year;
    private String description;

    // зависимости
    private Long personId;
}
