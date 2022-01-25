package com.example.universitytt.service;

import com.example.universitytt.model.Group;
import java.util.List;

public interface GroupService {
    Group save(Group group);

    Group getById(Long id);

    List<Group> getAll();

    void delete(Long id);
}
