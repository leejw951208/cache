package com.example.cache.member;

import com.example.cache.group.domain.Group;
import com.example.cache.group.repository.GroupRepository;
import com.example.cache.groupmember.repository.GroupMemberRepository;
import com.example.cache.member.domain.Member;
import com.example.cache.member.domain.MemberGroup;
import com.example.cache.member.domain.MemberSave;
import com.example.cache.member.mapper.MemberMapper;
import com.example.cache.member.repository.MemberRepository;
import com.example.cache.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {
    @Mock
    private MemberRepository memberRepository;

    @Mock
    private GroupMemberRepository groupMemberRepository;

    @Mock
    private GroupRepository groupRepository;

    @Mock
    private MemberMapper memberMapper;

    @InjectMocks
    private MemberService memberService;

    @Test
    public void save() {
        // given
        String memberName = "유저1";
        int age = 20;
        MemberSave memberSave = new MemberSave(memberName, age);

        given(memberRepository.save(memberSave)).willReturn(1L);

        // when
        long savedId = memberService.saveMember(memberSave);

        // then
        assertEquals(savedId, 1L);
    }

    @Test
    public void find() {
        // given
        long memberId = 1L;
        String memberName = "유저1";
        int age = 20;
        LocalDateTime createdDate = LocalDateTime.now();

        Member member = new Member(1L, memberName, age, createdDate);
        Optional<Long> groupId = Optional.of(1L);
        Group group = new Group(1L, "그룹1", createdDate);
        MemberGroup memberGroup = new MemberGroup(memberId, memberName, age, createdDate, group);

        given(memberRepository.findById(memberId)).willReturn(member);
        given(groupMemberRepository.findByMemberId(memberId)).willReturn(groupId);
        given(groupRepository.findById(groupId.get())).willReturn(group);
        given(memberMapper.toDomain(member, group)).willReturn(memberGroup);

        // when
        MemberGroup findMemberGroup = memberService.findMember(memberId);

        // then
        assertEquals(findMemberGroup, memberGroup);
        assertEquals(findMemberGroup.getGroup(), group);
    }
}
