package com.example.jobsearch.controllers;

import com.example.jobsearch.converter.CompanyDtoConverter;
import com.example.jobsearch.dto.CompanyDto;
import com.example.jobsearch.entity.enums.RequiredPosition;
import com.example.jobsearch.entity.enums.Status;
import com.example.jobsearch.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;
    private final CompanyDtoConverter dtoConverter;

    @GetMapping
    ResponseEntity<List<CompanyDto>> getAll(){
         return ResponseEntity.ok(companyService.getAll().stream()
                .map(dtoConverter::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    ResponseEntity<CompanyDto> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(dtoConverter.toDto(companyService.getById(id)));
    }

    @PostMapping("/add")
    ResponseEntity<CompanyDto> add(@RequestBody CompanyDto companyDto){
        return ResponseEntity.ok(dtoConverter.toDto(companyService.create(
                dtoConverter.createEntity(companyDto))));
    }

    @GetMapping("/name/{companyName}")
    ResponseEntity<CompanyDto> getByName(@PathVariable("companyName") String companyName){
        return ResponseEntity.ok(dtoConverter.toDto(companyService.getByName(companyName)));
    }

    @GetMapping("/position/{position}")
    ResponseEntity<List<CompanyDto>> getByRequiredPosition(@PathVariable("position") RequiredPosition position){
        return ResponseEntity.ok(companyService.getAllByRequiredPosition(position).stream()
        .map(dtoConverter::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/invocationStatus/{invocationStatus}")
    ResponseEntity <List<CompanyDto>> getByInvocationStatus(@PathVariable("invocationStatus") Status status){
        return ResponseEntity.ok(companyService.getAllByInvocationStatus(status).stream().map(
                dtoConverter::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/location/{location}")
    ResponseEntity <List<CompanyDto>> getByLocation(@PathVariable("location") String location){
        return ResponseEntity.ok(companyService.getAllByLocation(location).stream()
                .map(dtoConverter::toDto).collect(Collectors.toList()));
    }
}
