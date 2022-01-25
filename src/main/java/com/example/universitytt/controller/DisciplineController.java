package com.example.universitytt.controller;

import com.example.universitytt.dto.request.DisciplineRequestDto;
import com.example.universitytt.dto.response.DisciplineResponseDto;
import com.example.universitytt.model.Discipline;
import com.example.universitytt.service.DisciplineService;
import com.example.universitytt.service.mapper.DisciplineMapper;
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
@RequestMapping("/disciplines")
public class DisciplineController {
    private final DisciplineService disciplineService;
    private final DisciplineMapper disciplineMapper;

    public DisciplineController(DisciplineService disciplineService,
                                DisciplineMapper disciplineMapper) {
        this.disciplineService = disciplineService;
        this.disciplineMapper = disciplineMapper;
    }

    @GetMapping
    public List<DisciplineResponseDto> getAll() {
        return disciplineService.getAll()
                .stream()
                .map(disciplineMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public DisciplineResponseDto add(@RequestBody DisciplineRequestDto disciplineRequestDto) {
        return disciplineMapper.mapToDto(disciplineService
                .save(disciplineMapper.mapToModel(disciplineRequestDto)));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id,
                       @RequestBody DisciplineRequestDto disciplineRequestDto) {
        Discipline discipline = disciplineMapper.mapToModel(disciplineRequestDto);
        discipline.setId(id);
        disciplineService.save(discipline);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        disciplineService.delete(id);
    }
}
