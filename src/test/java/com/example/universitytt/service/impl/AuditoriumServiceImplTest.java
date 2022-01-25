package com.example.universitytt.service.impl;

import java.util.List;
import com.example.universitytt.dao.AuditoriumDao;
import com.example.universitytt.model.Auditorium;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AuditoriumServiceImplTest {
    @InjectMocks
    private AuditoriumServiceImpl auditoriumService;
    @Mock
    private AuditoriumDao auditoriumDao;
    private Auditorium auditoriumA;
    private Auditorium auditoriumB;

    @BeforeEach
    void init() {
        auditoriumA = new Auditorium();
        auditoriumA.setCapacity(100);
        auditoriumA.setDescription("auditorium");
        auditoriumB = new Auditorium();
        auditoriumB.setCapacity(150);
        auditoriumB.setDescription("auditoriumB");
    }

    @Test
    void save_Ok() {
        Mockito.when(auditoriumDao.save(auditoriumA)).thenReturn(auditoriumA);
        Auditorium actual = auditoriumService.save(auditoriumA);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(auditoriumA, actual);
    }

    @Test
    void getById_Ok() {
        auditoriumA.setId(1L);
        Mockito.when(auditoriumDao.getById(1L)).thenReturn(auditoriumA);
        Auditorium actual = auditoriumService.getById(1L);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(auditoriumA, actual);
    }

    @Test
    void getAll_Ok() {
        auditoriumA.setId(1L);
        auditoriumB.setId(2L);
        Mockito.when(auditoriumDao.findAll()).thenReturn(List.of(auditoriumA, auditoriumB));
        List<Auditorium> actual = auditoriumService.getAll();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(List.of(auditoriumA, auditoriumB), actual);
    }
}