package com.semicoloncohort13group1capstoneproject.careerconnect.data.model;

import com.semicoloncohort13group1capstoneproject.careerconnect.constants.UserRole;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// User: Represents a user of the system, including jobseekers, employers, and administrators.
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

//    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole userRole;

}
