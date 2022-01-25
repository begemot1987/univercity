package com.example.universitytt.service.impl;

import com.example.universitytt.dao.TeacherDao;
import com.example.universitytt.model.Teacher;
import com.example.universitytt.service.TeacherService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherDao teacherDao;

    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherDao.save(teacher);
    }

    @Override
    public Teacher getById(Long id) {
        return teacherDao.getById(id);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherDao.findAll();
    }

    @Override
    public void delete(Long id) {
        teacherDao.deleteById(id);
    }
}
