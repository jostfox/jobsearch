package com.example.jobsearch.controllers;

import com.example.jobsearch.converter.CompanyDtoConverter;
import com.example.jobsearch.dto.CompanyDto;
import com.example.jobsearch.entity.enums.RequiredPosition;
import com.example.jobsearch.entity.enums.Status;
import com.example.jobsearch.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Company controller",
        description = "Provides CRUD operations with the companies")
@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;
    private final CompanyDtoConverter dtoConverter;

    @Operation(summary = "List of all companies", description = "Get a list of all companies")
    @GetMapping
    ResponseEntity<List<CompanyDto>> getAll() {
        return ResponseEntity.ok(companyService.getAll().stream().map(dtoConverter::toDto)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    ResponseEntity<CompanyDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(dtoConverter.toDto(companyService.getById(id)));
    }

    @PostMapping("/add")
    void add(@RequestBody CompanyDto companyDto) {
        companyService.create(dtoConverter.createEntity(companyDto));
    }

    @GetMapping("/name/{companyName}")
    ResponseEntity<CompanyDto> getByName(@PathVariable("companyName") String companyName) {
        return ResponseEntity.ok(dtoConverter.toDto(companyService.getByName(companyName)));
    }

    @GetMapping("/position/{position}")
    ResponseEntity<List<CompanyDto>> getByRequiredPosition(@PathVariable("position") RequiredPosition position) {
        return ResponseEntity.ok(companyService.getAllByRequiredPosition(position).stream()
                .map(dtoConverter::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/invocationStatus/{invocationStatus}")
    ResponseEntity<List<CompanyDto>> getByInvocationStatus(@PathVariable("invocationStatus") Status status) {
        return ResponseEntity.ok(companyService.getAllByInvocationStatus(status).stream()
                .map(dtoConverter::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/location/{location}")
    ResponseEntity<List<CompanyDto>> getByLocation(@PathVariable("location") String location) {
        return ResponseEntity.ok(companyService.getAllByLocation(location).stream()
                .map(dtoConverter::toDto).collect(Collectors.toList()));
    }

    @DeleteMapping("/delete/{companyName}")
    void delete(@PathVariable("companyName") String companyName) {
        companyService.delete(companyName);
    }

    @PutMapping("/updateInvocation/{companyName}")
    ResponseEntity<CompanyDto> updateInvocation(@PathVariable("companyName") String companyName,
                                                @RequestBody CompanyDto companyDto) {
        return ResponseEntity.ok(dtoConverter.toDto(companyService.updateInvocation(companyName,
                companyDto)));
    }

    @PutMapping("/update/{companyName}")
    ResponseEntity<CompanyDto> update(@PathVariable("companyName") String companyName,
                                      @RequestBody CompanyDto companyDto) {
        return ResponseEntity.ok(dtoConverter.toDto(companyService.update(companyName, companyDto)));
    }
}
