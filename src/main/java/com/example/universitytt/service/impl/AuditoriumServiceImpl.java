package com.example.universitytt.service.impl;

import com.example.universitytt.dao.AuditoriumDao;
import com.example.universitytt.model.Auditorium;
import com.example.universitytt.service.AuditoriumService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {
    private final AuditoriumDao auditoriumDao;

    public AuditoriumServiceImpl(AuditoriumDao auditoriumDao) {
        this.auditoriumDao = auditoriumDao;
    }

    @Override
    public Auditorium save(Auditorium auditorium) {
        return auditoriumDao.save(auditorium);
    }

    @Override
    public Auditorium getById(Long id) {
        return auditoriumDao.getById(id);
    }

    public List<Auditorium> getAll() {
        return auditoriumDao.findAll();
    }

    @Override
    public void delete(Long id) {
        auditoriumDao.deleteById(id);
    }
}
