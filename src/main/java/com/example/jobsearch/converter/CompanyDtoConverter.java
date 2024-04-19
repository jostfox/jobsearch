package com.example.jobsearch.converter;

import com.example.jobsearch.dto.CompanyDto;
import com.example.jobsearch.entity.Company;

import com.example.jobsearch.entity.Invocation;
import com.example.jobsearch.entity.enums.Status;
import com.example.jobsearch.service.CompanyService;
import com.example.jobsearch.service.InvocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@RequiredArgsConstructor
public class CompanyDtoConverter implements DtoConverter<CompanyDto, Company> {

    private final InvocationService invocationService;
    private final CompanyService companyService;

    @Override
    public CompanyDto toDto(Company company) {
        return CompanyDto.builder()
                .companyName(company.getCompanyName())
                .location(company.getLocation())
                .requiredPosition(company.getRequiredPosition())
                .invocationStatus(company.getInvocation().getStatus().toString())
                .email(company.getEmail())
                .workingPlace(company.getWorkingPlace())
                .webPage(company.getWebPage())
                .phone(company.getPhone())
                .build();
    }

    @Override
    public Company toEntity(CompanyDto companyDto) {
        return Company.builder()
                .companyName(companyDto.getCompanyName())
                .location(companyDto.getLocation())
                .requiredPosition(companyDto.getRequiredPosition())
                .invocation(invocationService.getByStatus(companyDto.getInvocationStatus()))
                .email(companyDto.getEmail())
                .workingPlace(companyDto.getWorkingPlace())
                .webPage(companyDto.getWebPage())
                .phone(companyDto.getPhone())
                .build();
    }

    @Override
    public Company createEntity(CompanyDto companyDto) {
        return Company.builder()
                .companyName(companyDto.getCompanyName())
                .location(companyDto.getLocation())
                .requiredPosition(companyDto.getRequiredPosition())
//                .invocation(Invocation.builder()
//                        .creationDate(new Timestamp(System.currentTimeMillis()))
//                        .status(Status.NOT_CONTACTED)
//                        .build())
                .email(companyDto.getEmail())
                .workingPlace(companyDto.getWorkingPlace())
                .webPage(companyDto.getWebPage())
                .phone(companyDto.getPhone())
                .build();
    }
}
