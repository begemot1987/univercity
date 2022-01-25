package com.example.universitytt.service.mapper;

public interface ResponseDtoMapper<D, M> {
    D mapToDto(M model);
}
