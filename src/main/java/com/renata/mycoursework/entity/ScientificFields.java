package com.renata.mycoursework.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
import java.util.Collections;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@EqualsAndHashCode(exclude = {"outstandingPeople"})
@ToString(exclude = {"outstandingPeople"})

@Builder
@Entity
@Table(name = "scientific_fields")

public class ScientificFields {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "scientific_fields_id_seq")
    @SequenceGenerator(name = "scientific_fields_id_seq", sequenceName = "scientific_fields_id_seq", allocationSize = 1, initialValue = 13)
    private Long id;

    @Column (nullable = false, unique = true)
    private String name;

    @Column (name = "short_name")
    private String shortName;

    @OneToMany(mappedBy = "scientificFields", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<OutstandingPeople> outstandingPeople = Collections.emptySet();
}
