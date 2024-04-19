package com.example.jobsearch.repositories;

import com.example.jobsearch.entity.Invocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvocationRepository extends JpaRepository<Invocation, Long> {
}
