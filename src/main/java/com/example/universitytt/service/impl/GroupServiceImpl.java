package com.example.universitytt.service.impl;

import com.example.universitytt.dao.GroupDao;
import com.example.universitytt.model.Group;
import com.example.universitytt.service.GroupService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupDao groupDao;

    public GroupServiceImpl(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public Group save(Group group) {
        return groupDao.save(group);
    }

    @Override
    public Group getById(Long id) {
        return groupDao.getById(id);
    }

    @Override
    public List<Group> getAll() {
        return groupDao.findAll();
    }

    @Override
    public void delete(Long id) {
        groupDao.deleteById(id);
    }
}
