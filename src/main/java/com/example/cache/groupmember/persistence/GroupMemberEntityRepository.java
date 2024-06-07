package com.example.cache.groupmember.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupMemberEntityRepository extends JpaRepository<GroupMemberEntity, Long> {
    Optional<GroupMemberEntity> findByMemberEntityId(long memberId);
}
