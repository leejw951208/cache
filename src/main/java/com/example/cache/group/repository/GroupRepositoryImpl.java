package com.example.cache.group.repository;

import com.example.cache.group.domain.Group;
import com.example.cache.group.domain.GroupSave;
import com.example.cache.group.mapper.GroupMapper;
import com.example.cache.group.persistence.GroupEntity;
import com.example.cache.group.persistence.GroupEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class GroupRepositoryImpl implements GroupRepository {
    private final GroupEntityRepository groupEntityRepository;
    private final GroupMapper groupMapper;

    @Override
    public long save(GroupSave groupSave) {
        GroupEntity createdEntity = groupMapper.toEntity(groupSave);
        return groupEntityRepository.save(createdEntity).getId();
    }

    @Override
    public long save(Group group) {
        GroupEntity groupEntity = groupMapper.toEntity(group);
        return groupEntityRepository.save(groupEntity).getId();
    }

    @Override
    public Group findById(long groupId) {
        GroupEntity findEntity = groupEntityRepository.findById(groupId)
                .orElseThrow(() -> new NoSuchElementException("그룹을 찾을 수 업습니다."));
        return groupMapper.toDomain(findEntity);
    }
}
