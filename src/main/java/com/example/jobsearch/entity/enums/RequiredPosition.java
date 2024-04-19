package com.example.jobsearch.entity.enums;


import com.fasterxml.jackson.annotation.JsonValue;

public enum RequiredPosition {

    INTERN ("Intern"),
    JUNIOR ("Junior"),
    MIDDLE ("Middle"),
    SENIOR ("Senior"),
    DEVELOPER("Developer");

    private final String value;

    RequiredPosition(String value){
        this.value = value;
    }

    @JsonValue
    public String getValue(){
        return value;
    }
}
