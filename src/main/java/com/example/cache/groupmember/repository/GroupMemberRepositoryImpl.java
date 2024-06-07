package com.example.cache.groupmember.repository;

import com.example.cache.group.domain.Group;
import com.example.cache.group.mapper.GroupMapper;
import com.example.cache.group.persistence.GroupEntity;
import com.example.cache.groupmember.domain.ByMember;
import com.example.cache.groupmember.mapper.GroupMemberMapper;
import com.example.cache.groupmember.persistence.GroupMemberEntity;
import com.example.cache.groupmember.persistence.GroupMemberEntityRepository;
import com.example.cache.member.domain.Member;
import com.example.cache.member.mapper.MemberMapper;
import com.example.cache.member.persistence.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GroupMemberRepositoryImpl implements GroupMemberRepository {
    private final GroupMemberEntityRepository groupMemberEntityRepository;
    private final GroupMemberMapper groupMemberMapper;
    private final GroupMapper groupMapper;
    private final MemberMapper memberMapper;

    @Override
    public void save(Group group, List<Member> members) {
        GroupEntity groupEntity = groupMapper.toEntity(group);
        List<MemberEntity> memberEntities = memberMapper.toEntity(members);
        groupMemberEntityRepository.saveAll(groupMemberMapper.toEntity(groupEntity, memberEntities));
    }

    @Override
    public Optional<Long> findByMemberId(long memberId) {
        Optional<GroupMemberEntity> findEntity = groupMemberEntityRepository.findByMemberEntityId(memberId);
        return findEntity.map(groupMemberEntity -> groupMemberEntity.getGroupEntity().getId());
    }
}
