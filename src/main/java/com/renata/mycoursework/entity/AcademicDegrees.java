package com.renata.mycoursework.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@EqualsAndHashCode(exclude = {"outstandingPeople"})
@ToString(exclude = {"outstandingPeople"})

@Builder
@Entity
@Table(name = "academic_degrees")

public class AcademicDegrees {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "academic_degrees_id_seq")
    @SequenceGenerator(name = "academic_degrees_id_seq", sequenceName = "academic_degrees_id_seq", allocationSize = 1, initialValue = 3)
    private Long id;

    @Column (nullable = false, unique = true)
    private String name;

    @Column (name = "short_name")
    private String shortName;

    @OneToMany(mappedBy = "academicDegrees", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<OutstandingPeople> outstandingPeople = Collections.emptySet();
}
