package com.example.universitytt.dao;

import com.example.universitytt.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDao extends JpaRepository<Teacher, Long> {
    Teacher findByName(String name);
}
