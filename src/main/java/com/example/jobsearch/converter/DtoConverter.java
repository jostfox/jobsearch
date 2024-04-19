package com.example.jobsearch.converter;

public interface DtoConverter <D, E>{

    D toDto(E entity);

    E toEntity (D dto);

    E createEntity(D dto);
}
