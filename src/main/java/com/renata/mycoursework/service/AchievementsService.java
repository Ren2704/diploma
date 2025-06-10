package com.renata.mycoursework.service;

import com.renata.mycoursework.controller.request.achievements.AchievementsCreateRequest;
import com.renata.mycoursework.controller.request.achievements.AchievementsUpdateRequest;
import com.renata.mycoursework.entity.Achievements;

import java.util.List;
import java.util.Optional;

public interface AchievementsService {
    List<Achievements> findAll();
    Optional<Achievements> findById(Long id);
    Achievements create(AchievementsCreateRequest achievementsCreateRequest);
    Achievements update(AchievementsUpdateRequest achievementsUpdateRequest);
    void delete(Long id);
}
