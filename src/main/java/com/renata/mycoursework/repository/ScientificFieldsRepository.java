package com.renata.mycoursework.repository;

import com.renata.mycoursework.entity.ScientificFields;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScientificFieldsRepository extends JpaRepository<ScientificFields, Long> {
    Optional<ScientificFields> findByName(String name);
}
