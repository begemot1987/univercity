package com.example.universitytt.dao;

import com.example.universitytt.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupDao extends JpaRepository<Group, Long> {
    Group findByName(String name);
}
