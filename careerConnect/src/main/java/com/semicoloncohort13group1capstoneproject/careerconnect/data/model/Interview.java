package com.semicoloncohort13group1capstoneproject.careerconnect.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "interviews")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

// Interview: Represents an interview scheduled between an employer and a jobseeker.
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter(AccessLevel.NONE)
//    @Setter(AccessLevel.NONE)
    @Column(name = "interview_id")
    private Long interviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_seeker_id", nullable = false)
    private JobSeeker jobSeeker;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id", nullable = false)
    private Employer employer;

    // Use LocalDateTime if you need to store the exact date and time of the interview together with precision up to the seconds level.
    @Column(name = "interview_date_time", nullable = false)
    private LocalDateTime interviewDateTime;

    // Use separate LocalDate and LocalTime fields, if you need to store the date and time components separately, and don't require the second-level precision,
//    @Column(nullable = false)
//    private LocalDate date;
//
//    @Column(nullable = false)
//    private LocalTime time;

    @Column(nullable = false)
    private String interviewLocation;



}
