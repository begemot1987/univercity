package com.example.universitytt.service.impl;

import com.example.universitytt.dao.DisciplineDao;
import com.example.universitytt.model.Discipline;
import com.example.universitytt.service.DisciplineService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DisciplineServiceImpl implements DisciplineService {
    private final DisciplineDao disciplineDao;

    public DisciplineServiceImpl(DisciplineDao disciplineDao) {
        this.disciplineDao = disciplineDao;
    }

    @Override
    public Discipline save(Discipline discipline) {
        return disciplineDao.save(discipline);
    }

    @Override
    public Discipline getById(Long id) {
        return disciplineDao.getById(id);
    }

    @Override
    public List<Discipline> getAll() {
        return disciplineDao.findAll();
    }

    @Override
    public void delete(Long id) {
        disciplineDao.deleteById(id);
    }
}
