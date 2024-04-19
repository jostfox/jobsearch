package com.example.jobsearch.controllers;

import com.example.jobsearch.converter.InvocationDtoConverter;
import com.example.jobsearch.dto.InvocationDto;
import com.example.jobsearch.service.InvocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/invocation")
@RequiredArgsConstructor
public class InvocationController {

    private final InvocationService invocationService;
    private final InvocationDtoConverter dtoConverter;

    @GetMapping()
    ResponseEntity<List<InvocationDto>> getAll(){
        return ResponseEntity.ok(invocationService.getAll().stream()
                .map(dtoConverter::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    ResponseEntity<InvocationDto> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(dtoConverter.toDto(invocationService.getById(id)));
    }

    @PostMapping("/add")
    ResponseEntity<InvocationDto> create(@RequestBody InvocationDto invocationDto){
        return ResponseEntity.ok(dtoConverter.toDto(invocationService.create(dtoConverter
                .toEntity(invocationDto))));
    }

    @GetMapping("/status/{status}")
    ResponseEntity<InvocationDto> getByStatus(@PathVariable("status") String status){
        return ResponseEntity.ok(dtoConverter.toDto(invocationService.getByStatus(status)));
    }

    @GetMapping("/result/{result}")
    ResponseEntity<InvocationDto> getByResult(@PathVariable("result") String result){
        return ResponseEntity.ok(dtoConverter.toDto(invocationService.getByResult(result)));
    }
}
