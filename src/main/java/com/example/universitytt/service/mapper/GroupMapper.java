package com.example.universitytt.service.mapper;

import com.example.universitytt.dto.request.GroupRequestDto;
import com.example.universitytt.dto.response.GroupResponseDto;
import com.example.universitytt.model.Group;
import com.example.universitytt.service.TeacherService;
import org.springframework.stereotype.Component;

@Component
public class GroupMapper implements RequestDtoMapper<GroupRequestDto, Group>,
        ResponseDtoMapper<GroupResponseDto, Group> {
    private final TeacherService teacherService;

    public GroupMapper(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    public Group mapToModel(GroupRequestDto dto) {
        Group group = new Group();
        group.setName(dto.getName());
        group.setCurator(teacherService.getById(dto.getCuratorId()));
        return group;
    }

    @Override
    public GroupResponseDto mapToDto(Group model) {
        GroupResponseDto responseDto = new GroupResponseDto();
        responseDto.setId(model.getId());
        responseDto.setName(model.getName());
        responseDto.setCuratorId(model.getCurator().getId());
        return responseDto;
    }
}
