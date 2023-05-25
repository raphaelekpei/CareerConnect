package com.semicoloncohort13group1capstoneproject.careerconnect.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public enum NotificationStatus {

    READ("Read"),
    UNREAD("Unread");

    private final String statusName;

}
