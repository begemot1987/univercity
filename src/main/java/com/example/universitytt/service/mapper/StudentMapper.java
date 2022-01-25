package com.example.universitytt.service.mapper;

import com.example.universitytt.dto.request.StudentRequestDto;
import com.example.universitytt.dto.response.StudentResponseDto;
import com.example.universitytt.model.Student;
import com.example.universitytt.service.GroupService;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper implements RequestDtoMapper<StudentRequestDto, Student>,
        ResponseDtoMapper<StudentResponseDto, Student> {
    private final GroupService groupService;

    public StudentMapper(GroupService groupService) {
        this.groupService = groupService;
    }

    @Override
    public Student mapToModel(StudentRequestDto dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setLastName(dto.getLastName());
        student.setGroup(groupService.getById(dto.getGroupId()));
        return student;
    }

    @Override
    public StudentResponseDto mapToDto(Student model) {
        StudentResponseDto responseDto = new StudentResponseDto();
        responseDto.setId(model.getId());
        responseDto.setName(model.getName());
        responseDto.setLastName(model.getLastName());
        responseDto.setGroupId(model.getGroup().getId());
        return responseDto;
    }
}
