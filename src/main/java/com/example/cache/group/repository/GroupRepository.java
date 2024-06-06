package com.example.cache.group.repository;

import com.example.cache.group.domain.Group;
import com.example.cache.group.domain.GroupTest;

public interface GroupRepository {
    void save(String groupName);
    Group findById(long id);

    GroupTest findByIdTest(long id);
}
