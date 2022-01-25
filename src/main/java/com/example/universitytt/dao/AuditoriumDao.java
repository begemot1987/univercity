package com.example.universitytt.dao;

import com.example.universitytt.model.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumDao extends JpaRepository<Auditorium, Long> {
}
