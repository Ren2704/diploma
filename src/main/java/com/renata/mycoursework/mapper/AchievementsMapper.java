package com.renata.mycoursework.mapper;

import com.renata.mycoursework.controller.request.achievements.AchievementsCreateRequest;
import com.renata.mycoursework.entity.Achievements;

public interface AchievementsMapper {
    <T extends AchievementsCreateRequest> Achievements requestMapToAchievements(Achievements achievements, T request);
}
