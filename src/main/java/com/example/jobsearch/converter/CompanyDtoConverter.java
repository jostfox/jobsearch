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
                .vacancyStatus(company.getVacancyStatus())
                .invocationStatus(company.getInvocation().getStatus().toString())
                .invocationResult ((company.getInvocation().getInvResult() != null)
                        ? company.getInvocation().getInvResult().toString() : null)
                .resultDescription((company.getInvocation().getResultDescription() != null)
                        ? company.getInvocation().getResultDescription() : null)
                .email(company.getEmail())
                .contactName(company.getContactName())
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
                .vacancyStatus(companyDto.getVacancyStatus())
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
                .vacancyStatus(companyDto.getVacancyStatus())
                .email(companyDto.getEmail())
                .contactName(companyDto.getContactName())
                .workingPlace(companyDto.getWorkingPlace())
                .webPage(companyDto.getWebPage())
                .phone(companyDto.getPhone())
                .build();
    }
}
