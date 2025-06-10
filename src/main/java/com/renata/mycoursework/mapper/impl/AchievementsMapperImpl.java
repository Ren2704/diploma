package com.renata.mycoursework.mapper.impl;

import com.renata.mycoursework.controller.request.achievements.AchievementsCreateRequest;
import com.renata.mycoursework.entity.Achievements;
import com.renata.mycoursework.entity.OutstandingPeople;
import com.renata.mycoursework.mapper.AchievementsMapper;
import com.renata.mycoursework.repository.AchievementsRepository;
import com.renata.mycoursework.repository.OutstandingPeopleRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class AchievementsMapperImpl implements AchievementsMapper {

    private final OutstandingPeopleRepository outstandingPeopleRepository;

    public AchievementsMapperImpl(OutstandingPeopleRepository outstandingPeopleRepository){
        this.outstandingPeopleRepository = outstandingPeopleRepository;
    }

    @Override
    public <T extends AchievementsCreateRequest> Achievements requestMapToAchievements(Achievements achievements, T request) {
        if (request == null)
            return null;
        achievements.setTitle(request.getTitle());
        achievements.setYear(request.getYear());
        achievements.setDescription(request.getDescription());

        Optional<OutstandingPeople> person = outstandingPeopleRepository.findById(request.getPersonId());
        if (person.isPresent())
            achievements.setPerson(person.get());

        return achievements;
    }
}
