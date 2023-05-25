package com.semicoloncohort13group1capstoneproject.careerconnect.data.model;

import com.semicoloncohort13group1capstoneproject.careerconnect.constants.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "job_seekers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

// JobSeeker: Represents a person who is looking for employment opportunities
public class JobSeeker extends User {

//    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String middleName;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String phoneNumber;

    private LocalDate dateOfBirth;
    private String age;
    private String homeAddress;
    private  String photo;

    private String linkedinProfile;
    private String githubProfile;
    private String portfolioWebsiteUrl;

    private String resume;
    private String coverLetter;

    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Skill> skills;

    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Application> applications;

    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Certification> certifications;

    // The mappedBy attribute specifies the inverse side of the relationship, which is the jobSeeker attribute in the Certification class.
    // The cascade = CascadeType.ALL ensures that any changes made to the JobSeeker entity cascade to the associated Certification entities.
    // The orphanRemoval = true specifies that if a Certification entity is removed from the certifications' collection, it should be deleted from the database.

    // We will collect this information, but we will not make it accessible to employers
    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WorkExperience> workExperience;

    //  The mappedBy attribute specifies the inverse side of the relationship, which is the jobSeeker attribute in the WorkExperience class.
    //  The cascade = CascadeType.ALL ensures that any changes made to the JobSeeker entity cascade to the associated WorkExperience entities.
    //  The orphanRemoval = true specifies that if a WorkExperience entity is removed from the workExperience collection, it should be deleted from the database.

    // change this to enum
    @Column(nullable = false)
    private String highestEducationAttained;

    // This relationship allows multiple jobseekers to be associated with multiple employers.
    // Each jobseeker can have multiple employers interested in their profile, and each employer can be interested in multiple jobseekers.

    @ManyToMany(mappedBy = "jobSeekers")
    private List<Employer> employers;

    @OneToMany(mappedBy = "jobSeeker")
    private List<Notification> notifications;


    public JobSeeker(Long userId, String username, String password, String email, UserRole userRole,
                     String firstName, String lastName, String phoneNumber, String photo, String resume,
                     String coverLetter) {
        super(userId, username, password, email, userRole);
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName + " " + middleName;
        this.phoneNumber = phoneNumber;
        this.photo = photo;
        this.resume = resume;
        this.coverLetter = coverLetter;
        this.skills = new ArrayList<>();
        this.applications = new ArrayList<>();
    }

}


