package com.example.universitytt.config;

import com.example.universitytt.enums.Day;
import com.example.universitytt.model.Auditorium;
import com.example.universitytt.model.Discipline;
import com.example.universitytt.model.Group;
import com.example.universitytt.model.Lecture;
import com.example.universitytt.model.Student;
import com.example.universitytt.model.Teacher;
import com.example.universitytt.service.AuditoriumService;
import com.example.universitytt.service.DisciplineService;
import com.example.universitytt.service.GroupService;
import com.example.universitytt.service.LectureService;
import com.example.universitytt.service.StudentService;
import com.example.universitytt.service.TeacherService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final DisciplineService disciplineService;
    private final AuditoriumService auditoriumService;
    private final LectureService lectureService;
    private final GroupService groupService;

    public DataInitializer(StudentService studentService,
                           TeacherService teacherService,
                           DisciplineService disciplineService,
                           AuditoriumService auditoriumService,
                           GroupService groupService,
                           LectureService lectureService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.disciplineService = disciplineService;
        this.auditoriumService = auditoriumService;
        this.lectureService = lectureService;
        this.groupService = groupService;
    }

    @PostConstruct
    public void init() {
        Discipline biology = new Discipline();
        biology.setName("Biology");
        biology.setDescription("Anatomy and biology");
        disciplineService.save(biology);
        Discipline physic = new Discipline();
        physic.setName("Physic");
        physic.setDescription("Quantum physic");
        disciplineService.save(physic);

        Auditorium auditoriumA = new Auditorium();
        auditoriumA.setCapacity(100);
        auditoriumA.setDescription("Physic laboratory");
        auditoriumService.save(auditoriumA);
        Auditorium auditoriumB = new Auditorium();
        auditoriumB.setCapacity(150);
        auditoriumB.setDescription("Biology auditorium");
        auditoriumService.save(auditoriumB);

        Teacher teacher = new Teacher();
        teacher.setName("john");
        teacher.setLastName("weak");
        teacher.setDegree("M.D.");
        teacherService.save(teacher);

        Lecture lectureA = new Lecture();
        lectureA.setAuditorium(auditoriumA);
        lectureA.setDiscipline(physic);
        lectureA.setTeacher(teacher);
        lectureA.setDay(Day.MONDAY);
        lectureService.save(lectureA);

        Lecture lectureB = new Lecture();
        lectureB.setAuditorium(auditoriumB);
        lectureB.setDiscipline(biology);
        lectureB.setTeacher(teacher);
        lectureB.setDay(Day.MONDAY);
        lectureService.save(lectureB);

        Group group = new Group();
        group.setCurator(teacher);
        group.setName("a-1");
        groupService.save(group);

        Student student = new Student();
        student.setName("bob");
        student.setLastName("bobko");
        student.setGroup(group);
        student.setSchedule(List.of(lectureA, lectureB));
        studentService.save(student);
    }
}
