package com.example.universitytt.service.mapper;

import com.example.universitytt.dto.request.AuditoriumRequestDto;
import com.example.universitytt.dto.response.AuditoriumResponseDto;
import com.example.universitytt.model.Auditorium;
import org.springframework.stereotype.Component;

@Component
public class AuditoriumMapper implements RequestDtoMapper<AuditoriumRequestDto, Auditorium>,
        ResponseDtoMapper<AuditoriumResponseDto, Auditorium> {
    @Override
    public Auditorium mapToModel(AuditoriumRequestDto dto) {
        Auditorium auditorium = new Auditorium();
        auditorium.setCapacity(dto.getCapacity());
        auditorium.setDescription(dto.getDescription());
        return auditorium;
    }

    @Override
    public AuditoriumResponseDto mapToDto(Auditorium model) {
        AuditoriumResponseDto responseDto = new AuditoriumResponseDto();
        responseDto.setId(model.getId());
        responseDto.setCapacity(model.getCapacity());
        responseDto.setDescription(model.getDescription());
        return responseDto;
    }
}
