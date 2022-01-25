package com.example.universitytt.service;

import com.example.universitytt.model.Auditorium;
import java.util.List;

public interface AuditoriumService {
    Auditorium save(Auditorium auditorium);

    Auditorium getById(Long id);

    List<Auditorium> getAll();

    void delete(Long id);
}
