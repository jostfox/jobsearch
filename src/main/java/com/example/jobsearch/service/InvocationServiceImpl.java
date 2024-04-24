package com.example.jobsearch.service;

import com.example.jobsearch.entity.Invocation;
import com.example.jobsearch.entity.enums.Result;
import com.example.jobsearch.entity.enums.Status;
import com.example.jobsearch.exceptions.ItemNotFoundException;
import com.example.jobsearch.repositories.InvocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvocationServiceImpl implements InvocationService {

    private final InvocationRepository invocationRepository;

    @Override
    public List<Invocation> getAll() {
        return invocationRepository.findAll();
    }

    @Override
    public Invocation getById(Long id) {
        return invocationRepository.findById(id).orElseThrow(()-> new ItemNotFoundException(String
                .format("Invocation with id %d not found", id)));
    }

    @Override
    public Invocation create(Invocation invocation) {
        return invocationRepository.save(invocation);
    }

    @Override
    public Invocation getByStatus(String status) {
        return invocationRepository.findAll().stream().filter(
                invocation -> invocation.getStatus().equals(Status.valueOf(status)))
                .findFirst().orElseThrow(() -> new ItemNotFoundException(
                        String.format("Invocation with status \"%s\" not found", status)));
    }

    @Override
    public Invocation getByResult(String result) {
        return invocationRepository.findAll().stream().filter(
                invocation -> invocation.getInvResult().equals(Result.valueOf(result)))
                .findFirst().orElseThrow(() -> new ItemNotFoundException(
                        String.format("Invocation with result \"%s\" not found", result)));
    }
}
