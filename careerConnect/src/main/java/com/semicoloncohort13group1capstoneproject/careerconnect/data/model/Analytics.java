package com.semicoloncohort13group1capstoneproject.careerconnect.data.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "analytics")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
// Analytics: Represents data and metrics related to recruitment activities and performance.
public class Analytics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "analytics_id")
    private Long analyticsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    //  This field represents the number of job applications received for a particular job vacancy
    //  The applicationCount field is typically used in the Analytics entity to track and analyze the number of applications received for a specific job.
//    @Column(nullable = false)
    private Integer applicationCount;

    // This field represents the time taken to hire a candidate for a job vacancy
    // It will store the time when the hiring process was completed.
    // The timeToHire field is usually measured in days or weeks and is used in the Analytics entity to track and analyze the average or total time it takes to fill a job position.
    @Column(nullable = false)
    private Integer timeToHire;

    // This field represents the conversion rate or the percentage of job applications that result in successful hires
    // The conversionRate field is calculated by dividing the number of successful hires by the total number of job applications and multiplying by 100.
    // It is used in the Analytics entity to measure and analyze the effectiveness of the recruitment process.
    @Column(nullable = false)
    private Double conversionRate;


}
