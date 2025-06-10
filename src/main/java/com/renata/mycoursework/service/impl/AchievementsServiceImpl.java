package com.renata.mycoursework.service.impl;

import com.renata.mycoursework.controller.request.academicTitles.AcademicTitlesUpdateRequest;
import com.renata.mycoursework.controller.request.achievements.AchievementsCreateRequest;
import com.renata.mycoursework.controller.request.achievements.AchievementsUpdateRequest;
import com.renata.mycoursework.entity.AcademicTitles;
import com.renata.mycoursework.entity.Achievements;
import com.renata.mycoursework.mapper.AchievementsMapper;
import com.renata.mycoursework.repository.AchievementsRepository;
import com.renata.mycoursework.service.AchievementsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AchievementsServiceImpl implements AchievementsService {

    private final AchievementsRepository achievementsRepository;
    private final AchievementsMapper achievementsMapper;

    public AchievementsServiceImpl(AchievementsRepository achievementsRepository, AchievementsMapper achievementsMapper) {
        this.achievementsRepository = achievementsRepository;
        this.achievementsMapper = achievementsMapper;
    }

    @Override
    public List<Achievements> findAll() {
        return achievementsRepository.findAll();
    }

    @Override
    public Optional<Achievements> findById(Long id) {
        return achievementsRepository.findById(id);
    }

    @Override
    public Achievements create(AchievementsCreateRequest achievementsCreateRequest) {
        Achievements achievements = new Achievements();
        achievements = achievementsMapper.requestMapToAchievements(achievements, achievementsCreateRequest);
        return achievementsRepository.save(achievements);
    }

    @Override
    public Achievements update(AchievementsUpdateRequest achievementsUpdateRequest) {
        Optional<Achievements> optionalAchievements = achievementsRepository.findById(achievementsUpdateRequest.getId());
        if (optionalAchievements.isPresent()) {
            Achievements achievements = optionalAchievements.get();
            achievements = achievementsMapper.requestMapToAchievements(achievements, achievementsUpdateRequest);
            return achievementsRepository.save(achievements);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        achievementsRepository.deleteById(id);
    }
}
