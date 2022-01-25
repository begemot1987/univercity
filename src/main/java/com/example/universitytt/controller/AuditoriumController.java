package com.example.universitytt.controller;

import com.example.universitytt.dto.request.AuditoriumRequestDto;
import com.example.universitytt.dto.response.AuditoriumResponseDto;
import com.example.universitytt.model.Auditorium;
import com.example.universitytt.service.AuditoriumService;
import com.example.universitytt.service.mapper.AuditoriumMapper;
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
@RequestMapping("/auditoriums")
public class AuditoriumController {
    private final AuditoriumService auditoriumService;
    private final AuditoriumMapper auditoriumMapper;

    public AuditoriumController(AuditoriumService auditoriumService,
                                AuditoriumMapper auditoriumMapper) {
        this.auditoriumService = auditoriumService;
        this.auditoriumMapper = auditoriumMapper;
    }

    @GetMapping
    public List<AuditoriumResponseDto> getAll() {
        return auditoriumService.getAll()
                .stream()
                .map(auditoriumMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public AuditoriumResponseDto add(@RequestBody AuditoriumRequestDto auditoriumRequestDto) {
        return auditoriumMapper.mapToDto(auditoriumService
                .save(auditoriumMapper.mapToModel(auditoriumRequestDto)));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,
                       @RequestBody AuditoriumRequestDto auditoriumRequestDto) {
        Auditorium auditorium = auditoriumMapper.mapToModel(auditoriumRequestDto);
        auditorium.setId(id);
        auditoriumService.save(auditorium);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        auditoriumService.delete(id);
    }
}
