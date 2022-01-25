package com.example.universitytt.service;

import com.example.universitytt.model.Discipline;
import java.util.List;

public interface DisciplineService {
    Discipline save(Discipline discipline);

    Discipline getById(Long id);

    List<Discipline> getAll();

    void delete(Long id);
}
