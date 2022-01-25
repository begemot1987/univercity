package com.example.universitytt.dao;

import com.example.universitytt.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureDao extends JpaRepository<Lecture, Long> {
}
