package com.semicoloncohort13group1capstoneproject.careerconnect.data.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "skills")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

// Skill: Represents a specific skill or qualification required for a job.
public class Skill {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Long skillId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;

    @ManyToOne
    private JobSeeker jobSeeker;

    public Skill(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
