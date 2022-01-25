package com.example.universitytt.controller;

import com.example.universitytt.dto.request.GroupRequestDto;
import com.example.universitytt.dto.response.GroupResponseDto;
import com.example.universitytt.model.Group;
import com.example.universitytt.service.GroupService;
import com.example.universitytt.service.mapper.GroupMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;
    private final GroupMapper groupMapper;

    public GroupController(GroupService groupService,
                           GroupMapper groupMapper) {
        this.groupService = groupService;
        this.groupMapper = groupMapper;
    }

    @GetMapping
    public List<GroupResponseDto> getAll() {
        return groupService.getAll()
                .stream()
                .map(groupMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public GroupResponseDto add(@RequestBody GroupRequestDto groupRequestDto) {
        return groupMapper.mapToDto(groupService.save(groupMapper.mapToModel(groupRequestDto)));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody GroupRequestDto groupRequestDto) {
        Group group = groupMapper.mapToModel(groupRequestDto);
        group.setId(id);
        groupService.save(group);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        groupService.delete(id);
    }
}
