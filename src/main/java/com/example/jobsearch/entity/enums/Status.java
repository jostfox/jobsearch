package com.example.jobsearch.entity.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {

    NOT_CONTACTED ("Not Contacted"),
    CONTACTED ("Contacted"),
    REPLIED ("Replied"),
    NOT_REPLIED ("Not Replied");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
