package com.example.cache.group.service;

import com.example.cache.group.domain.Group;
import com.example.cache.group.domain.GroupTest;
import com.example.cache.group.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    @Transactional
    public void saveGroup(String groupName) {
        groupRepository.save(groupName);
    }

    @Cacheable(cacheNames = "group", key = "#groupId", condition = "#groupId != null", cacheManager = "cacheManager")
    @Transactional(readOnly = true)
    public Group findGroup(long groupId) {
        return groupRepository.findById(groupId);
    }
}
