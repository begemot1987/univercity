package com.example.universitytt.controller;

import com.example.universitytt.dto.request.StudentRequestDto;
import com.example.universitytt.dto.response.LectureResponseDto;
import com.example.universitytt.dto.response.StudentResponseDto;
import com.example.universitytt.model.Student;
import com.example.universitytt.service.StudentService;
import com.example.universitytt.service.mapper.LectureMapper;
import com.example.universitytt.service.mapper.StudentMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;
    private final LectureMapper lectureMapper;

    public StudentController(StudentService studentService,
                             StudentMapper studentMapper,
                             LectureMapper lectureMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
        this.lectureMapper = lectureMapper;
    }

    @GetMapping
    public List<StudentResponseDto> getAll() {
        return studentService.getAll()
                .stream()
                .map(studentMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public List<LectureResponseDto> getLectureByDay(@PathVariable Long id,
                                                    @RequestParam String day) {
        return studentService.getScheduleByDay(id, day)
                .stream()
                .map(lectureMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public StudentResponseDto add(@RequestBody StudentRequestDto studentRequestDto) {
        return studentMapper
                .mapToDto(studentService.save(studentMapper.mapToModel(studentRequestDto)));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody StudentRequestDto studentRequestDto) {
        Student student = studentMapper.mapToModel(studentRequestDto);
        student.setId(id);
        studentService.save(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
