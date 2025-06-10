package com.renata.mycoursework.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.renata.mycoursework.entity.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.Collections;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@EqualsAndHashCode(exclude = {"academicTitles", "academicDegrees", "scientificFields", "publications", "achievements", "personJob"})
@ToString(exclude = {"academicTitles", "academicDegrees", "scientificFields", "publications", "achievements", "personJob"})

@Builder
@Entity
@Table(name = "outstanding_people")

public class OutstandingPeople {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "outstanding_people_id_seq")
    @SequenceGenerator(name = "outstanding_people_id_seq", sequenceName = "outstanding_people_id_seq", allocationSize = 1, initialValue = 21)
    private Long id;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private String surname;

    @Column (nullable = false)
    private String patronymic;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender = Gender.NOT_SELECTED;

    @Column(name = "year_of_birth", nullable = true)
    private int yearOfBirth;

    @Column(name = "year_of_death")
    private Integer yearOfDeath;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column (columnDefinition = "TEXT")
    private String biography;

    @ManyToOne
    @JoinColumn(name = "id_academic_titles")
    @JsonBackReference
    private AcademicTitles academicTitles;

    @ManyToOne
    @JoinColumn(name = "id_academic_degrees")
    @JsonBackReference
    private AcademicDegrees academicDegrees;

    @ManyToOne
    @JoinColumn(name = "id_scientific_fields")
    @JsonBackReference
    private ScientificFields scientificFields;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Publications> publications = Collections.emptySet();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Achievements> achievements = Collections.emptySet();

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<PersonJob> personJob = Collections.emptySet();
}
