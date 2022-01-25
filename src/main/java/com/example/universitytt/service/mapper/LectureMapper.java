package com.example.universitytt.service.mapper;

import com.example.universitytt.dto.request.LectureRequestDto;
import com.example.universitytt.dto.response.LectureResponseDto;
import com.example.universitytt.enums.Day;
import com.example.universitytt.model.Lecture;
import com.example.universitytt.service.AuditoriumService;
import com.example.universitytt.service.DisciplineService;
import com.example.universitytt.service.TeacherService;
import org.springframework.stereotype.Component;

@Component
public class LectureMapper implements RequestDtoMapper<LectureRequestDto, Lecture>,
        ResponseDtoMapper<LectureResponseDto, Lecture> {
    private final AuditoriumService auditoriumService;
    private final DisciplineService disciplineService;
    private final TeacherService teacherService;

    public LectureMapper(AuditoriumService auditoriumService,
                         DisciplineService disciplineService,
                         TeacherService teacherService) {
        this.auditoriumService = auditoriumService;
        this.disciplineService = disciplineService;
        this.teacherService = teacherService;
    }

    @Override
    public Lecture mapToModel(LectureRequestDto dto) {
        Lecture lecture = new Lecture();
        lecture.setDiscipline(disciplineService.getById(dto.getDisciplineId()));
        lecture.setTeacher(teacherService.getById(dto.getTeacherId()));
        lecture.setAuditorium(auditoriumService.getById(dto.getAuditoriumId()));
        lecture.setDay(Day.valueOf(dto.getDay().toUpperCase()));
        return lecture;
    }

    @Override
    public LectureResponseDto mapToDto(Lecture model) {
        LectureResponseDto responseDto = new LectureResponseDto();
        responseDto.setId(model.getId());
        responseDto.setAuditoriumId(model.getAuditorium().getId());
        responseDto.setDisciplineId(model.getDiscipline().getId());
        responseDto.setTeacherId(model.getTeacher().getId());
        responseDto.setDay(model.getDay().name());
        return responseDto;
    }
}
