package com.semicoloncohort13group1capstoneproject.careerconnect.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter

//  the ApplicationStatus enum class represents the various statuses that an application can have: "Pending", "In Progress", "Rejected", and "Hired".
//  Each enum value has a corresponding statusName string.
public enum ApplicationStatus {

    PENDING("Pending"),
    IN_PROGRESS("In Progress"),
    REJECTED("Rejected"),
    HIRED("Hired");

    private final String statusName;


}
