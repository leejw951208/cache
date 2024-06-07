package com.example.cache.member.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberEntityRepository extends JpaRepository<MemberEntity, Long> {
    List<MemberEntity> findByIdIn(List<Long> memberIds);
}
