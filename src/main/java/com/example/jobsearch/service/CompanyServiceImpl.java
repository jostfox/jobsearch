package com.example.jobsearch.service;

import com.example.jobsearch.entity.Company;
import com.example.jobsearch.entity.Invocation;
import com.example.jobsearch.entity.enums.RequiredPosition;
import com.example.jobsearch.entity.enums.Status;
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
        return companyRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(
                String.format("Company with id %d not found", id)));
    }

    @Override
    public Company getByName(String companyName) {
        return getAll().stream().filter(company -> company.getCompanyName().equals(companyName))
                .findFirst().orElseThrow(() -> new ItemNotFoundException(String.format("Company with name \"%s\" not found", companyName)));
    }

    @Override
    public List<Company> getAllByRequiredPosition(RequiredPosition position) {
        return getAll().stream().filter(company -> company.getRequiredPosition() == position)
                .collect(Collectors.toList());
    }

    @Override
    public Company create(Company company) {
        companyRepository.save(company);
        Invocation invocation =
                Invocation.builder().company(company).creationDate(new Timestamp(System.currentTimeMillis()))
                        .status(Status.NOT_CONTACTED).build();
        invocationRepository.save(invocation);
        company.setInvocation(invocation);
        return company;
    }

    @Override
    public List<Company> getAllByInvocationStatus(Status status) {
        return getAll().stream().filter(company -> company.getInvocation()
                .getStatus() == status).collect(Collectors.toList());
    }

    @Override
    public List<Company> getAllByLocation(String location) {
        return getAll().stream().filter(company -> company.getLocation().contains(location)
        ).collect(Collectors.toList());
    }
}
