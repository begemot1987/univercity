package com.example.universitytt.service.mapper;

import com.example.universitytt.dto.request.TeacherRequestDto;
import com.example.universitytt.dto.response.TeacherResponseDto;
import com.example.universitytt.model.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper implements RequestDtoMapper<TeacherRequestDto, Teacher>,
        ResponseDtoMapper<TeacherResponseDto, Teacher> {
    @Override
    public Teacher mapToModel(TeacherRequestDto dto) {
        Teacher teacher = new Teacher();
        teacher.setName(dto.getName());
        teacher.setLastName(dto.getLastName());
        teacher.setDegree(dto.getDegree());
        return teacher;
    }

    @Override
    public TeacherResponseDto mapToDto(Teacher model) {
        TeacherResponseDto responseDto = new TeacherResponseDto();
        responseDto.setId(model.getId());
        responseDto.setName(model.getName());
        responseDto.setLastName(model.getLastName());
        responseDto.setDegree(model.getDegree());
        return responseDto;
    }
}
