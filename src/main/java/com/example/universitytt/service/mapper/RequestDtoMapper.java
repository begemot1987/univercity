package com.example.universitytt.service.mapper;

public interface RequestDtoMapper<D, M> {
    M mapToModel(D dto);
}
