package com.example.cache.member.repository;

import com.example.cache.group.domain.Group;
import com.example.cache.member.domain.Member;
import com.example.cache.member.domain.MemberSave;

import java.util.List;

public interface MemberRepository {
    long save(MemberSave memberSave);
    Member findById(long memberId);
    List<Member> findByIds(List<Long> memberIds);
}
