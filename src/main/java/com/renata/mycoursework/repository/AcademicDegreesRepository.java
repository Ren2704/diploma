package com.renata.mycoursework.repository;

import com.renata.mycoursework.entity.AcademicDegrees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcademicDegreesRepository extends JpaRepository<AcademicDegrees, Long> {
    Optional<AcademicDegrees> findByName(String name);
}
