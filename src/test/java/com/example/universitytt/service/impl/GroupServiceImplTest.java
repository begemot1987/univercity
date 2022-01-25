package com.example.universitytt.service.impl;

import java.util.List;
import com.example.universitytt.dao.GroupDao;
import com.example.universitytt.model.Group;
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
class GroupServiceImplTest {
    @InjectMocks
    private GroupServiceImpl groupService;
    @Mock
    private GroupDao groupDao;
    private Group groupA;
    private Group groupB;

    @BeforeEach
    void init() {
        groupA = new Group();
        groupA.setName("GroupA");
        Teacher teacherBob = new Teacher();
        teacherBob.setName("Bob");
        teacherBob.setLastName("First");
        teacherBob.setDegree("M.D.");
        groupA.setCurator(teacherBob);
        groupB = new Group();
        groupB.setName("GroupB");
        Teacher teacherAlice = new Teacher();
        teacherAlice.setName("Alice");
        teacherAlice.setLastName("Cooper");
        teacherAlice.setDegree("PhD");
        groupB.setCurator(teacherAlice);
    }

    @Test
    void save_Ok() {
        Mockito.when(groupDao.save(groupA)).thenReturn(groupA);
        Group actual = groupService.save(groupA);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(groupA, actual);
    }

    @Test
    void getById_Ok() {
        Long id = 1L;
        groupA.setId(id);
        Mockito.when(groupDao.getById(id)).thenReturn(groupA);
        Group actual = groupService.getById(id);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(groupA, actual);
    }

    @Test
    void getAll_Ok() {
        groupA.setId(1L);
        groupB.setId(2L);
        Mockito.when(groupDao.findAll()).thenReturn(List.of(groupA, groupB));
        List<Group> actual = groupService.getAll();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(List.of(groupA, groupB), actual);
    }
}