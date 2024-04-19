package com.example.jobsearch.converter;

import com.example.jobsearch.dto.InvocationDto;
import com.example.jobsearch.entity.Invocation;
import com.example.jobsearch.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
@RequiredArgsConstructor
public class InvocationDtoConverter implements DtoConverter<InvocationDto, Invocation> {

    private final CompanyService companyService;

    @Override
    public InvocationDto toDto(Invocation invocation) {
        return InvocationDto.builder()
                .companyName(invocation.getCompany().getCompanyName())
                .date(invocation.getCreationDate())
                .status(invocation.getStatus())
                .result(invocation.getInvResult())
                .resultDescription(invocation.getResultDescription())
                .build();
    }

    @Override
    public Invocation toEntity(InvocationDto invocationDto) {
        return Invocation.builder()
                .company(companyService.getByName(invocationDto.getCompanyName()))
                .creationDate(new Timestamp(System.currentTimeMillis()))
                .status(invocationDto.getStatus())
                .invResult(invocationDto.getResult())
                .resultDescription(invocationDto.getResultDescription())
                .build();
    }

    @Override
    public Invocation createEntity(InvocationDto dto) {
        return Invocation.builder()
                .company(companyService.getByName(dto.getCompanyName()))
                .creationDate(new Timestamp(System.currentTimeMillis()))
                .status(dto.getStatus())
                .invResult(dto.getResult())
                .resultDescription(dto.getResultDescription())
                .build();
    }
}
