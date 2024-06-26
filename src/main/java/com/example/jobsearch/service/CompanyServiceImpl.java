package com.example.jobsearch.service;

import com.example.jobsearch.dto.CompanyDto;
import com.example.jobsearch.entity.Company;
import com.example.jobsearch.entity.Invocation;
import com.example.jobsearch.entity.enums.RequiredPosition;
import com.example.jobsearch.entity.enums.Status;
import com.example.jobsearch.exceptions.ExistingCompanyException;
import com.example.jobsearch.exceptions.ItemNotFoundException;
import com.example.jobsearch.repositories.CompanyRepository;
import com.example.jobsearch.repositories.InvocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final InvocationRepository invocationRepository;

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company getById(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(String.format("Company with id %d not found", id)));
    }

    @Override
    public Company getByName(String companyName) {
        return getAll().stream().filter(company -> company.getCompanyName().equals(companyName)).findFirst().orElseThrow(() -> new ItemNotFoundException(String.format("Company with name \"%s\" not found", companyName)));
    }

    @Override
    public List<Company> getAllByRequiredPosition(RequiredPosition position) {
        return getAll().stream().filter(company -> company.getRequiredPosition() == position).collect(Collectors.toList());
    }

    @Override
    public void create(Company company) {
        if (getAll().stream().anyMatch(company1 ->
                company1.getCompanyName().equals(company.getCompanyName())
                        && company1.getLocation().equals(company.getLocation())
                        && company1.getRequiredPosition().equals(company.getRequiredPosition()))) {
            throw new ExistingCompanyException(String.format("Company with name \"%s\" already exists"
                    , company.getCompanyName()));
        }
        companyRepository.save(company);
        Invocation invocation =
                Invocation.builder()
                        .company(company)
                        .creationDate(new Timestamp(System.currentTimeMillis()))
                        .status(Status.NOT_CONTACTED)
                        .build();
        invocationRepository.save(invocation);
        company.setInvocation(invocation);
    }

    @Override
    public List<Company> getAllByInvocationStatus(Status status) {
        return getAll().stream().filter(company -> company.getInvocation().getStatus() == status).collect(Collectors.toList());
    }

    @Override
    public List<Company> getAllByLocation(String location) {
        return getAll().stream().filter(company -> company.getLocation().contains(location)).collect(Collectors.toList());
    }

    @Override
    public Company update(String companyName, CompanyDto companyDto) {
        Company company = getByName(companyName);
        company.setVacancyStatus(companyDto.getVacancyStatus() != null ? companyDto.getVacancyStatus()
                : company.getVacancyStatus());
        company.setCompanyName(companyDto.getCompanyName() != null ? companyDto.getCompanyName()
                : company.getCompanyName());
        company.setEmail(companyDto.getEmail() != null ? companyDto.getEmail()
                : company.getEmail());
        company.setPhone(companyDto.getPhone() != null ? companyDto.getPhone()
                : company.getPhone());
        company.setWebPage(companyDto.getWebPage() != null ? companyDto.getWebPage()
                : company.getWebPage());
        return companyRepository.save(company);
    }

    @Override
    public void delete(String companyName) {
        Company company = getByName(companyName);
        companyRepository.delete(company);
    }

    @Override
    public Company updateInvocation(String companyName, CompanyDto companyDto) {
        Company company = getByName(companyName);
        Invocation invocation = company.getInvocation();
        invocation.setStatus(companyDto.getInvocationStatus() != null ? companyDto.getInvocationStatus()
                : company.getInvocation().getStatus());
        invocation.setInvResult(companyDto.getInvocationResult() != null ? companyDto.getInvocationResult()
                : company.getInvocation().getInvResult());
        invocation.setResultDescription(companyDto.getResultDescription() != null ? companyDto.getResultDescription()
                : company.getInvocation().getResultDescription());
        invocationRepository.save(invocation);
        return companyRepository.save(company);
    }
}
