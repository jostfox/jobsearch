package com.example.jobsearch.dto;

import com.example.jobsearch.entity.Company;
import com.example.jobsearch.entity.enums.Result;
import com.example.jobsearch.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.sql.Timestamp;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class InvocationDto {

    private String companyName;
    private Timestamp date;
    private Status status;
    private Result result;
    private String resultDescription;
}
