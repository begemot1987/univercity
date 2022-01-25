package com.example.universitytt.service.impl;

import java.util.List;
import com.example.universitytt.dao.StudentDao;
import com.example.universitytt.enums.Day;
import com.example.universitytt.model.Auditorium;
import com.example.universitytt.model.Discipline;
import com.example.universitytt.model.Group;
import com.example.universitytt.model.Lecture;
import com.example.universitytt.model.Student;
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
class StudentServiceImplTest {
    @InjectMocks
    private StudentServiceImpl studentService;
    @Mock
    private StudentDao studentDao;
    private Student studentBob;
    private Student studentAlice;
    private Lecture lectureA;
    private Lecture lectureB;

    @BeforeEach
    void init() {
        Teacher teacherBob = new Teacher();
        teacherBob.setId(1L);
        teacherBob.setName("Bob");
        teacherBob.setLastName("First");
        teacherBob.setDegree("M.D.");
        Teacher teacherAlice = new Teacher();
        teacherAlice.setId(2L);
        teacherAlice.setName("Alice");
        teacherAlice.setLastName("Cooper");
        teacherAlice.setDegree("PhD");

        Discipline disciplineA = new Discipline();
        disciplineA.setId(1L);
        disciplineA.setName("Biology");
        disciplineA.setDescription("Anatomy");
        Discipline disciplineB = new Discipline();
        disciplineB.setId(2L);
        disciplineB.setName("Physic");
        disciplineB.setDescription("Quantum");

        Auditorium auditoriumA = new Auditorium();
        auditoriumA.setId(1L);
        auditoriumA.setCapacity(100);
        auditoriumA.setDescription("auditoriumA");
        Auditorium auditoriumB = new Auditorium();
        auditoriumB.setId(2L);
        auditoriumB.setCapacity(150);
        auditoriumB.setDescription("auditoriumB");

        lectureA = new Lecture();
        lectureA.setId(1L);
        lectureA.setTeacher(teacherBob);
        lectureA.setDay(Day.MONDAY);
        lectureA.setDiscipline(disciplineA);
        lectureA.setAuditorium(auditoriumA);
        lectureB = new Lecture();
        lectureB.setId(2L);
        lectureB.setTeacher(teacherAlice);
        lectureB.setDiscipline(disciplineB);
        lectureB.setAuditorium(auditoriumB);
        lectureB.setDay(Day.FRIDAY);

        Group groupA = new Group();
        groupA.setId(1L);
        groupA.setName("GroupA");
        groupA.setCurator(teacherBob);
        Group groupB = new Group();
        groupB.setId(2L);
        groupB.setName("GroupB");
        groupB.setCurator(teacherAlice);

        studentBob = new Student();
        studentBob.setName("Bob");
        studentBob.setLastName("Jr");
        studentBob.setGroup(groupA);
        studentBob.setSchedule(List.of(lectureA,lectureB));
        studentAlice = new Student();
        studentAlice.setName("Alice");
        studentAlice.setLastName("Second");
        studentAlice.setGroup(groupB);
        studentAlice.setSchedule(List.of(lectureA, lectureB));
    }

    @Test
    void save() {
        Mockito.when(studentDao.save(studentBob)).thenReturn(studentBob);
        Student actual = studentService.save(studentBob);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(studentBob, actual);
    }

    @Test
    void getById() {
        Long id = 1L;
        studentBob.setId(id);
        Mockito.when(studentDao.getById(id)).thenReturn(studentBob);
        Student actual = studentService.getById(id);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(studentBob, actual);
    }

    @Test
    void getAll() {
        studentBob.setId(1L);
        studentAlice.setId(2L);
        Mockito.when(studentDao.findAll()).thenReturn(List.of(studentAlice, studentBob));
        List<Student> actual = studentService.getAll();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(List.of(studentAlice, studentBob), actual);
    }

    @Test
    void getScheduleByDay() {
        String day = "monday";
        Long id = 1L;
        studentBob.setId(id);
        Mockito.when(studentDao.getById(id)).thenReturn(studentBob);
        List<Lecture> actual = studentService.getScheduleByDay(id, day);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(List.of(lectureA), actual);
    }
}