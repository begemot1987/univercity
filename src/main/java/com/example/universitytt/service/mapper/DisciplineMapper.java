package com.example.universitytt.service.mapper;

import com.example.universitytt.dto.request.DisciplineRequestDto;
import com.example.universitytt.dto.response.DisciplineResponseDto;
import com.example.universitytt.model.Discipline;
import org.springframework.stereotype.Component;

@Component
public class DisciplineMapper implements RequestDtoMapper<DisciplineRequestDto, Discipline>,
        ResponseDtoMapper<DisciplineResponseDto, Discipline> {
    @Override
    public Discipline mapToModel(DisciplineRequestDto dto) {
        Discipline discipline = new Discipline();
        discipline.setName(dto.getName());
        discipline.setDescription(discipline.getDescription());
        return discipline;
    }

    @Override
    public DisciplineResponseDto mapToDto(Discipline model) {
        DisciplineResponseDto responseDto = new DisciplineResponseDto();
        responseDto.setId(model.getId());
        responseDto.setName(model.getName());
        responseDto.setDescription(model.getName());
        return responseDto;
    }
}
