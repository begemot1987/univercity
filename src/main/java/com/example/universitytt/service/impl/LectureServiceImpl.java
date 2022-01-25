package com.example.universitytt.service.impl;

import com.example.universitytt.dao.LectureDao;
import com.example.universitytt.model.Lecture;
import com.example.universitytt.service.LectureService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LectureServiceImpl implements LectureService {
    private final LectureDao lectureDao;

    public LectureServiceImpl(LectureDao lectureDao) {
        this.lectureDao = lectureDao;
    }

    @Override
    public Lecture save(Lecture lecture) {
        return lectureDao.save(lecture);
    }

    @Override
    public Lecture getById(Long id) {
        return lectureDao.getById(id);
    }

    @Override
    public List<Lecture> getAll() {
        return lectureDao.findAll();
    }

    @Override
    public void delete(Long id) {
        lectureDao.deleteById(id);
    }
}
