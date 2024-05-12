package com.example.jobsearch.entity.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Result {

    AWAITING ("Awaiting"),
    INTERVIEW ("Interview"),
    NEXT_INTERVIEW ("Next Interview"),
    REFUSED ("Refused"),
    INTERVIEW_FAILED ("Interview Failed"),
    OFFER ("Offer");

    private final String value;

    Result(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
