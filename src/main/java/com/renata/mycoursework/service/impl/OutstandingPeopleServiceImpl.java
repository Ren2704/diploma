package com.renata.mycoursework.service.impl;

import com.renata.mycoursework.controller.request.outstandingPeople.OutstandingPeopleCreateRequest;
import com.renata.mycoursework.controller.request.outstandingPeople.OutstandingPeopleUpdateRequest;
import com.renata.mycoursework.entity.OutstandingPeople;
import com.renata.mycoursework.mapper.OutstandingPeopleMapper;
import com.renata.mycoursework.repository.OutstandingPeopleRepository;
import com.renata.mycoursework.service.OutstandingPeopleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutstandingPeopleServiceImpl implements OutstandingPeopleService {
    private final OutstandingPeopleRepository outstandingPeopleRepository;
    private final OutstandingPeopleMapper outstandingPeopleMapper;
    public OutstandingPeopleServiceImpl(OutstandingPeopleRepository outstandingPeopleRepository, OutstandingPeopleMapper outstandingPeopleMapper) {
        this.outstandingPeopleRepository = outstandingPeopleRepository;
        this.outstandingPeopleMapper = outstandingPeopleMapper;
    }
    @Override
    public List<OutstandingPeople> findAll() {
        return outstandingPeopleRepository.findAll();
    }
    @Override
    public Optional<OutstandingPeople> findById(Long id) {
        return outstandingPeopleRepository.findById(id);
    }
    @Override
    public OutstandingPeople create(OutstandingPeopleCreateRequest outstandingPeopleCreateRequest) {
        OutstandingPeople outstandingPeople = new OutstandingPeople();
        outstandingPeople =
                outstandingPeopleMapper.requestMapToOutstandingPeople(outstandingPeople, outstandingPeopleCreateRequest);
        return outstandingPeopleRepository.save(outstandingPeople);
    }
    @Override
    public OutstandingPeople update(OutstandingPeopleUpdateRequest outstandingPeopleUpdateRequest) {
        Optional<OutstandingPeople> optionalOutstandingPeople =
                outstandingPeopleRepository.findById(outstandingPeopleUpdateRequest.getId());
        if (optionalOutstandingPeople.isPresent()) {
            OutstandingPeople outstandingPeople = optionalOutstandingPeople.get();
            outstandingPeople =
                    outstandingPeopleMapper.requestMapToOutstandingPeople(outstandingPeople, outstandingPeopleUpdateRequest);
            return outstandingPeopleRepository.save(outstandingPeople);
        }
        return null;
    }
    @Override public void delete(Long id) {
        outstandingPeopleRepository.deleteById(id);
    }
}
