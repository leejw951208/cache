package com.example.cache.group.repository;

import com.example.cache.group.domain.Group;
import com.example.cache.group.domain.GroupTest;
import com.example.cache.group.persistence.GroupEntity;
import com.example.cache.group.persistence.GroupEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;

@Repository
@RequiredArgsConstructor
public class GroupRepositoryImpl implements GroupRepository {
    private final GroupEntityRepository groupEntityRepository;

    @Override
    public void save(String groupName) {
        groupEntityRepository.save(
                GroupEntity.builder()
                        .name(groupName)
                        .build()
        );
    }

    @Override
    public Group findById(long id) {
        GroupEntity findEntity = groupEntityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("그룹을 찾을 수 업습니다."));
        return new Group(findEntity.getId(), findEntity.getName(), findEntity.getCreatedDate());
    }

    @Override
    public GroupTest findByIdTest(long id) {
        GroupEntity findEntity = groupEntityRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("그룹을 찾을 수 업습니다."));
        return GroupTest.builder()
                .groupId(findEntity.getId())
                .groupName(findEntity.getName())
                .createdDate(findEntity.getCreatedDate())
                .build();
    }
}
