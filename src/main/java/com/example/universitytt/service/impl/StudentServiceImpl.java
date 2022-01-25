package com.example.universitytt.service.impl;

import com.example.universitytt.dao.StudentDao;
import com.example.universitytt.enums.Day;
import com.example.universitytt.model.Lecture;
import com.example.universitytt.model.Student;
import com.example.universitytt.service.StudentService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student getById(Long id) {
        return studentDao.getById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentDao.findAll();
    }

    @Override
    public void delete(Long id) {
        studentDao.deleteById(id);
    }

    @Override
    public List<Lecture> getScheduleByDay(Long id, String day) {
        return studentDao.getById(id).getSchedule()
                .stream()
                .filter(lecture -> lecture.getDay().equals(Day.valueOf(day.toUpperCase())))
                .collect(Collectors.toList());
    }
}
