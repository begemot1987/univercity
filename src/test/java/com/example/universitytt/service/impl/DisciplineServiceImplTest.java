package com.example.universitytt.service.impl;

import java.util.List;
import com.example.universitytt.dao.DisciplineDao;
import com.example.universitytt.model.Discipline;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DisciplineServiceImplTest {
    @InjectMocks
    private DisciplineServiceImpl disciplineService;
    @Mock
    private DisciplineDao disciplineDao;
    private Discipline disciplineA;
    private Discipline disciplineB;

    @BeforeEach
    void init() {
        disciplineA = new Discipline();
        disciplineA.setName("Biology");
        disciplineA.setDescription("Anatomy");
        disciplineB = new Discipline();
        disciplineB.setName("Physic");
        disciplineB.setDescription("Quantum");
    }

    @Test
    void save_Ok() {
        Mockito.when(disciplineDao.save(disciplineA)).thenReturn(disciplineA);
        Discipline actual = disciplineService.save(disciplineA);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(disciplineA, actual);
    }

    @Test
    void getById_Ok() {
        Long id = 1L;
        disciplineA.setId(id);
        Mockito.when(disciplineDao.getById(id)).thenReturn(disciplineA);
        Discipline actual = disciplineService.getById(id);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(disciplineA, actual);
    }

    @Test
    void getAll_Ok() {
        disciplineA.setId(1L);
        disciplineB.setId(2L);
        Mockito.when(disciplineDao.findAll()).thenReturn(List.of(disciplineA, disciplineB));
        List<Discipline> actual = disciplineService.getAll();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(List.of(disciplineA, disciplineB), actual);
    }
}