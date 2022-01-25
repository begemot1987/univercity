package com.example.universitytt.controller;

import com.example.universitytt.dto.request.LectureRequestDto;
import com.example.universitytt.dto.response.LectureResponseDto;
import com.example.universitytt.model.Lecture;
import com.example.universitytt.service.LectureService;
import com.example.universitytt.service.mapper.LectureMapper;
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
@RequestMapping("/lectures")
public class LectureController {
    private final LectureService lectureService;
    private final LectureMapper lectureMapper;

    public LectureController(LectureService lectureService,
                             LectureMapper lectureMapper) {
        this.lectureService = lectureService;
        this.lectureMapper = lectureMapper;
    }

    @GetMapping
    public List<LectureResponseDto> getAll() {
        return lectureService.getAll()
                .stream()
                .map(lectureMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public LectureResponseDto add(@RequestBody LectureRequestDto lectureRequestDto) {
        return lectureMapper
                .mapToDto(lectureService.save(lectureMapper.mapToModel(lectureRequestDto)));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody LectureRequestDto lectureRequestDto) {
        Lecture lecture = lectureMapper.mapToModel(lectureRequestDto);
        lecture.setId(id);
        lectureService.save(lecture);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lectureService.delete(id);
    }
}
