package com.semicoloncohort13group1capstoneproject.careerconnect.data.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "work_experience")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(nullable = false)
    private Long workExperienceId;

    // This field stores the name of the company where the jobseeker worked
    @Column(nullable = false)
    private String company;

    // This field stores the job position held by the jobseeker during that work experience.
    @Column(nullable = false)
    private String position;

    // multiple work experiences can be associated with a single JobSeeker
    @ManyToOne
    @JoinColumn(name = "job_seeker_id", nullable = false)
    private JobSeeker jobSeeker;

}
