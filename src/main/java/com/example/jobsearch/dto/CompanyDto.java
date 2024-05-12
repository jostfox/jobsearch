package com.example.jobsearch.dto;

import com.example.jobsearch.entity.enums.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CompanyDto {

    private String companyName;
    private Set<String> location;
    private RequiredPosition requiredPosition;
    private VacancyStatus vacancyStatus;
    private Status invocationStatus;
    private Result invocationResult;
    private String resultDescription;
    private String email;
    private String contactName;
    private WorkingPlace workingPlace;
    private String webPage;
    private String phone;
}
