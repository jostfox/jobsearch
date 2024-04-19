package com.example.jobsearch.entity;

import com.example.jobsearch.entity.enums.RequiredPosition;
import com.example.jobsearch.entity.enums.WorkingPlace;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "company")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String companyName;

    @ElementCollection
    private Set<String> location = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private RequiredPosition requiredPosition;

    @OneToOne(mappedBy = "company", cascade = CascadeType.ALL)
    private Invocation invocation;

    private String email;

    @Enumerated(EnumType.STRING)
    private WorkingPlace workingPlace;

    private String webPage;
    private String phone;
}
