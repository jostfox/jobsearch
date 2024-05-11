package com.example.jobsearch.dto;

import com.example.jobsearch.entity.enums.RequiredPosition;
import com.example.jobsearch.entity.enums.Status;
import com.example.jobsearch.entity.enums.VacancyStatus;
import com.example.jobsearch.entity.enums.WorkingPlace;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Enumerated;
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
    private String invocationStatus;
    private String invocationResult;
    private String resultDescription;
    private String email;
    private String contactName;
    private WorkingPlace workingPlace;
    private String webPage;
    private String phone;
}
