package com.example.cache.groupmember.repository;

import com.example.cache.group.domain.Group;
import com.example.cache.member.domain.Member;

import java.util.List;
import java.util.Optional;

public interface GroupMemberRepository {
    void save(Group group, List<Member> members);
    Optional<Long> findByMemberId(long memberId);
}
