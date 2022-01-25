package com.example.universitytt.dao;

import com.example.universitytt.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineDao extends JpaRepository<Discipline, Long> {
    Discipline findByName(String name);
}
