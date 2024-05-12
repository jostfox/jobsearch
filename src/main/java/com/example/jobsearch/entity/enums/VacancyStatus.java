package com.example.jobsearch.entity.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VacancyStatus {

    ACTIVE("Active"),
    INACTIVE("Inactive");

    private final String value;

    VacancyStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
