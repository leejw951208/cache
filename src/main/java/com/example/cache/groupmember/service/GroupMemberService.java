package com.example.cache.groupmember.service;

import com.example.cache.group.domain.Group;
import com.example.cache.group.repository.GroupRepository;
import com.example.cache.groupmember.eventlistener.MemberCacheEvict;
import com.example.cache.groupmember.repository.GroupMemberRepository;
import com.example.cache.member.domain.Member;
import com.example.cache.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupMemberService {
    private final GroupMemberRepository groupMemberRepository;
    private final GroupRepository groupRepository;
    private final MemberRepository memberRepository;
    private final ApplicationEventPublisher publisher;

    @Transactional
    /*@Caching(evict = {
            @CacheEvict(cacheNames = "member", key = "#memberIds")
    })*/
    public void saveGroupMember(long groupId, List<Long> memberIds) {
        Group findGroup = groupRepository.findById(groupId);
        List<Member> findMembers = memberRepository.findByIds(memberIds);
        groupMemberRepository.save(findGroup, findMembers);
        publisher.publishEvent(new MemberCacheEvict(memberIds));
    }
}
