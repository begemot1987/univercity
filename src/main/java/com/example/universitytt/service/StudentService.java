package com.example.universitytt.service;

import com.example.universitytt.model.Lecture;
import com.example.universitytt.model.Student;
import java.util.List;

public interface StudentService {
    Student save(Student student);

    Student getById(Long id);

    List<Student> getAll();

    void delete(Long id);

    List<Lecture> getScheduleByDay(Long id, String day);
}
