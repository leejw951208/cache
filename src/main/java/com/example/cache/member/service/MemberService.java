package com.example.cache.member.service;

import com.example.cache.group.domain.Group;
import com.example.cache.group.repository.GroupRepository;
import com.example.cache.groupmember.repository.GroupMemberRepository;
import com.example.cache.member.domain.Member;
import com.example.cache.member.domain.MemberGroup;
import com.example.cache.member.domain.MemberSave;
import com.example.cache.member.dto.SaveMemberDto;
import com.example.cache.member.mapper.MemberMapper;
import com.example.cache.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final GroupRepository groupRepository;
    private final GroupMemberRepository groupMemberRepository;
    private final MemberMapper memberMapper;

    @Transactional
    public long saveMember(MemberSave memberSave) {
        return memberRepository.save(memberSave);
    }

    @Cacheable(key = "#memberId", condition = "#memberId > 0", cacheNames = "member")
    @Transactional(readOnly = true)
    public MemberGroup findMember(long memberId) {
        Member findMember = memberRepository.findById(memberId);
        Optional<Long> findGroupId = groupMemberRepository.findByMemberId(memberId);

        if (findGroupId.isEmpty()) {
            return memberMapper.toDomain(findMember, new Group(0L, null, null));
        }

        Group findGroup = groupRepository.findById(findGroupId.get());
        return memberMapper.toDomain(findMember, findGroup);
    }
}
