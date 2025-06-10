package com.renata.mycoursework.repository;

import com.renata.mycoursework.entity.AcademicTitles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcademicTitlesRepository extends JpaRepository<AcademicTitles, Long> {
    Optional<AcademicTitles> findByName(String name);
}
