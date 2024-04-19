package com.example.jobsearch.service;

import com.example.jobsearch.entity.Company;
import com.example.jobsearch.entity.enums.RequiredPosition;
import com.example.jobsearch.entity.enums.Status;

import java.util.List;

public interface CompanyService {

    List<Company> getAll();

    Company getById(Long id);

    Company getByName(String companyName);

    List<Company> getAllByRequiredPosition(RequiredPosition position);

    Company create(Company company);

    List<Company> getAllByInvocationStatus(Status status);

    List <Company> getAllByLocation(String location);


}
