package com.example.universitytt.service;

import com.example.universitytt.model.Lecture;
import java.util.List;

public interface LectureService {
    Lecture save(Lecture lecture);

    Lecture getById(Long id);

    List<Lecture> getAll();

    void delete(Long id);
}
