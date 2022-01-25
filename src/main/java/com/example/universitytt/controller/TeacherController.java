package com.example.universitytt.controller;

import com.example.universitytt.dto.request.TeacherRequestDto;
import com.example.universitytt.dto.response.TeacherResponseDto;
import com.example.universitytt.model.Teacher;
import com.example.universitytt.service.TeacherService;
import com.example.universitytt.service.mapper.TeacherMapper;
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
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;

    public TeacherController(TeacherService teacherService,
                             TeacherMapper teacherMapper) {
        this.teacherService = teacherService;
        this.teacherMapper = teacherMapper;
    }

    @GetMapping
    public List<TeacherResponseDto> getAll() {
        return teacherService.getAll()
                .stream()
                .map(teacherMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public TeacherResponseDto add(@RequestBody TeacherRequestDto teacherRequestDto) {
        return teacherMapper
                .mapToDto(teacherService.save(teacherMapper.mapToModel(teacherRequestDto)));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody TeacherRequestDto teacherRequestDto) {
        Teacher teacher = teacherMapper.mapToModel(teacherRequestDto);
        teacher.setId(id);
        teacherService.save(teacher);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        teacherService.delete(id);
    }
}
