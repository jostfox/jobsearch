package com.example.jobsearch.service;

import com.example.jobsearch.entity.Invocation;

import java.util.List;

public interface InvocationService {

    List<Invocation> getAll();

    Invocation getById(Long id);

    Invocation create(Invocation invocation);

    Invocation getByStatus(String status);

    Invocation getByResult(String result);
}
