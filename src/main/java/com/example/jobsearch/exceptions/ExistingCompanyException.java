package com.example.jobsearch.exceptions;

public class ExistingCompanyException extends RuntimeException{

    public ExistingCompanyException(String message){
        super(message);
    }
}
