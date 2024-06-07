package com.example.cache.group.repository;

import com.example.cache.group.domain.Group;
import com.example.cache.group.domain.GroupSave;

public interface GroupRepository {
    long save(GroupSave groupSave);
    Group findById(long groupId);
}
