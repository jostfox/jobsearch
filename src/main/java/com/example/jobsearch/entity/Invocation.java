package com.example.jobsearch.entity;

import com.example.jobsearch.entity.enums.Result;
import com.example.jobsearch.entity.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "invocation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne()
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    private Timestamp creationDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Result invResult;

    private String resultDescription;
}
