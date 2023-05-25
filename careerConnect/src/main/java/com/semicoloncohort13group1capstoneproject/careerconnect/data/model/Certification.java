package com.semicoloncohort13group1capstoneproject.careerconnect.data.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "certifications")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long certificationId;


//    @Column(nullable = false)
    private String name;

    //  multiple certifications can be associated with a single JobSeeker.
    @ManyToOne
    @JoinColumn(name = "job_seeker_id", nullable = false)
    private JobSeeker jobSeeker;

    // @JoinColumn is used to specify the foreign key column in the database table.
}
