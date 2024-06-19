package com.example.cache.group.service;

import com.example.cache.group.domain.Group;
import com.example.cache.group.domain.GroupSave;
import com.example.cache.group.mapper.GroupMapper;
import com.example.cache.group.persistence.GroupEntity;
import com.example.cache.group.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    private static final String CACHE_NAMES = "group";

    @Transactional
    public long saveGroup(GroupSave groupSave) {
        return groupRepository.save(groupSave);
    }

    @Cacheable(key = "'group_' + #groupId", condition = "#groupId > 0", cacheNames = CACHE_NAMES, cacheManager = "cacheManager")
    @Transactional(readOnly = true)
    public Group findGroup(long groupId) {
        return groupRepository.findById(groupId);
    }

    @Transactional
    @CacheEvict(key = "'group_' + #groupId", condition = "#groupId > 0", cacheNames = CACHE_NAMES, cacheManager = "cacheManager")
    public long updateGroup(long groupId, GroupSave groupSave) {
        Group findGroup = groupRepository.findById(groupId);
        findGroup.updateName(groupSave.getName());
        return groupRepository.save(findGroup);
    }
}
