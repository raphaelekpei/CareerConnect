package com.semicoloncohort13group1capstoneproject.careerconnect.data.model;

import com.semicoloncohort13group1capstoneproject.careerconnect.constants.JobStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "jobs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

//Job: Represents a job vacancy posted by an employer.
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobId;

//    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;

    @OneToMany
    private List<Skill> requiredSkills;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private Double salary;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private JobStatus status;

    // Multiple job vacancy can be associated with a single Employer.
   //  The @JoinColumn annotation specifies the name of the foreign key column in the Job table that references the primary key column of the Employer table.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id", nullable = false)
    private Employer employer;




    public Job(String title, String description, String location, Double salary) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.salary = salary;
    }

}
