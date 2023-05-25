package com.semicoloncohort13group1capstoneproject.careerconnect.data.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

// Employer: Represents an employer or company that posts job vacancies.
public class Employer extends User {

//    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String companyDescription;

    // @Column(nullable = false) is used to indicate that the marked field is a required field and cannot be null.

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String physicalAddress;

    @Column(nullable = false)
    private String websiteUrl;

    @Column(nullable = false)
    private String hiringManager;

    // An Employer can post multiple Jobs, as one employer can have multiple job vacancies.
    // The @OneToMany annotation, along with the mappedBy attribute, establishes the inverse side of the relationship. It indicates that the jobs field in the Employer entity maps the relationship based on the employer field in the Job entity.
    // the relationship between the Job entity and the Employer entity, allowing an employer to post and manage multiple job vacancies.
    @OneToMany(mappedBy = "employer")
    private List<Job> jobs;

    // An Employer can have multiple Applications, as one employer can receive and manage applications from multiple jobseekers.
    // The @OneToMany annotation, along with the mappedBy attribute, establishes the inverse side of the relationship. It indicates that the applications field in the Employer entity maps the relationship based on the employer field in the Application entity.
    // The relationship between the Application entity and the Employer entity, allowing an employer to manage and access the applications associated with them.
    @OneToMany(mappedBy = "employer")
    private List<Application> applications;

    // This relationship allows multiple jobseekers to be associated with multiple employers.
    // Each jobseeker can have multiple employers interested in their profile, and each employer can be interested in multiple jobseekers.
    //  The @JoinTable annotation specifies the name of the join table that will be created to store the relationship.
    //  The joinColumns attribute specifies the foreign key column name for the Employer entity, and
    //  the inverseJoinColumns attribute specifies the foreign key column name for the JobSeeker entity
    @ManyToMany
    @JoinTable(
            name = "job_seeker_employer",
            joinColumns = @JoinColumn(name = "employer_id"),
            inverseJoinColumns = @JoinColumn(name = "job_seeker_id")
    )
    private List<JobSeeker> jobSeekers;

    @OneToMany(mappedBy = "employer")
    private List<Notification> notifications;


    public Employer(String companyName, String physicalAddress, String companyDescription) {
        this.companyName = companyName;
        this.physicalAddress = physicalAddress;
        this.companyDescription = companyDescription;
        this.jobs = new ArrayList<>();
    }


}
