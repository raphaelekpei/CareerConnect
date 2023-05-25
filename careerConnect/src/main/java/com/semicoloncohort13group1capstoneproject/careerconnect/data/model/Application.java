package com.semicoloncohort13group1capstoneproject.careerconnect.data.model;

import com.semicoloncohort13group1capstoneproject.careerconnect.constants.ApplicationStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "applications")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

// Application: Represents a job application submitted by a jobseeker for a specific job.
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Long applicationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_seeker_id", nullable = false)
    private JobSeeker jobSeeker;

    @Column(nullable = false)
    private String resume;

    @Column(nullable = false)
    private String coverLetter;

    // @ManyToOne annotation indicates that multiple applications can be associated with a single employer.
    // The @JoinColumn annotation specifies the name of the foreign key column in the Application table that references the primary key column of the Employer table.
    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicationStatus status;



}
