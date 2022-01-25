package com.example.universitytt.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    @OneToMany
    @JoinTable(name = "students_lectures",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "lecture_id"))
    private List<Lecture> schedule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Lecture> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Lecture> schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Student{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", lastName='" + lastName + '\''
                + ", group=" + group
                + ", schedule=" + schedule
                + '}';
    }
}
