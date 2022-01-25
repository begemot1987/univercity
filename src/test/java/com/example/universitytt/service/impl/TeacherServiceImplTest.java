package com.example.universitytt.service.impl;

import java.util.List;
import com.example.universitytt.dao.TeacherDao;
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
class TeacherServiceImplTest {
    @InjectMocks
    private TeacherServiceImpl teacherService;
    @Mock
    private TeacherDao teacherDao;
    private Teacher teacherBob;
    private Teacher teacherAlice;

    @BeforeEach
    void init() {
        teacherBob = new Teacher();
        teacherBob.setName("Bob");
        teacherBob.setLastName("First");
        teacherBob.setDegree("M.D.");
        teacherAlice = new Teacher();
        teacherAlice.setName("Alice");
        teacherAlice.setLastName("Cooper");
        teacherAlice.setDegree("PhD");
    }

    @Test
    void save() {
        Mockito.when(teacherDao.save(teacherAlice)).thenReturn(teacherAlice);
        Teacher actual = teacherService.save(teacherAlice);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(teacherAlice, actual);
    }

    @Test
    void getById() {
        Long id = 1L;
        teacherBob.setId(id);
        Mockito.when(teacherDao.getById(id)).thenReturn(teacherBob);
        Teacher actual = teacherService.getById(id);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(teacherBob, actual);
    }

    @Test
    void getAll() {
        teacherBob.setId(1L);
        teacherAlice.setId(2L);
        Mockito.when(teacherDao.findAll()).thenReturn(List.of(teacherBob, teacherAlice));
        List<Teacher> actual = teacherService.getAll();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(List.of(teacherBob, teacherAlice), actual);
    }
}