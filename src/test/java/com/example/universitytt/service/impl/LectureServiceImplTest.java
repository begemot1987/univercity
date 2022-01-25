package com.example.universitytt.service.impl;

import java.util.List;
import com.example.universitytt.dao.LectureDao;
import com.example.universitytt.enums.Day;
import com.example.universitytt.model.Auditorium;
import com.example.universitytt.model.Discipline;
import com.example.universitytt.model.Lecture;
import com.example.universitytt.model.Teacher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class LectureServiceImplTest {
    @InjectMocks
    private LectureServiceImpl lectureService;
    @Mock
    private LectureDao lectureDao;
    private Lecture lectureA;
    private Lecture lectureB;

    @BeforeEach
    void init() {
        Teacher teacherBob = new Teacher();
        teacherBob.setName("Bob");
        teacherBob.setLastName("First");
        teacherBob.setDegree("M.D.");
        Teacher teacherAlice = new Teacher();
        teacherAlice.setName("Alice");
        teacherAlice.setLastName("Cooper");
        teacherAlice.setDegree("PhD");

        Discipline disciplineA = new Discipline();
        disciplineA.setName("Biology");
        disciplineA.setDescription("Anatomy");
        Discipline disciplineB = new Discipline();
        disciplineB.setName("Physic");
        disciplineB.setDescription("Quantum");

        Auditorium auditoriumA = new Auditorium();
        auditoriumA.setCapacity(100);
        auditoriumA.setDescription("auditoriumA");
        Auditorium auditoriumB = new Auditorium();
        auditoriumB.setCapacity(150);
        auditoriumB.setDescription("auditoriumB");

        lectureA = new Lecture();
        lectureA.setTeacher(teacherBob);
        lectureA.setDay(Day.MONDAY);
        lectureA.setDiscipline(disciplineA);
        lectureA.setAuditorium(auditoriumA);
        lectureB = new Lecture();
        lectureB.setTeacher(teacherAlice);
        lectureB.setDiscipline(disciplineB);
        lectureB.setAuditorium(auditoriumB);
        lectureB.setDay(Day.FRIDAY);
    }

    @Test
    void save() {
        Mockito.when(lectureDao.save(lectureA)).thenReturn(lectureA);
        Lecture actual = lectureService.save(lectureA);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(lectureA, actual);
    }

    @Test
    void getById() {
        Long id = 1L;
        lectureA.setId(id);
        Mockito.when(lectureDao.getById(id)).thenReturn(lectureA);
        Lecture actual = lectureService.getById(id);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(lectureA, actual);
    }

    @Test
    void getAll() {
        lectureA.setId(1L);
        lectureB.setId(2L);
        Mockito.when(lectureDao.findAll()).thenReturn(List.of(lectureA, lectureB));
        List<Lecture> actual = lectureService.getAll();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(List.of(lectureA, lectureB), actual);
    }
}