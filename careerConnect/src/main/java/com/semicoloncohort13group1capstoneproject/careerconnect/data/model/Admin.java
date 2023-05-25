package com.semicoloncohort13group1capstoneproject.careerconnect.data.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

// This class represents an admin who has access to manage the recruitment system.
public class Admin extends User {


//    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String fullName ;

    private String phoneNumber;

    private String department;
    private String role;

    @OneToMany(mappedBy = "admin")
    private List<Notification> notifications;

}
