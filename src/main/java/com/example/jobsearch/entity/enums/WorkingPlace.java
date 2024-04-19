package com.example.jobsearch.entity.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum WorkingPlace {

    HYBRID("Hybrid"),
    ON_SITE("On_site"),
    REMOTE("Remote");

    private final String value;

    WorkingPlace(String value){
        this.value = value;
    }

    @JsonValue
    public String getValue(){
        return value;
    }
}
