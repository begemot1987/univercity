package com.example.universitytt.service;

import com.example.universitytt.model.Teacher;
import java.util.List;

public interface TeacherService {
    Teacher save(Teacher teacher);

    Teacher getById(Long id);

    List<Teacher> getAll();

    void delete(Long id);
}
