package com.renata.mycoursework.repository;

import com.renata.mycoursework.entity.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobTitleRepository extends JpaRepository<JobTitle, Long> {
    Optional<JobTitle> findByName(String name);
}
