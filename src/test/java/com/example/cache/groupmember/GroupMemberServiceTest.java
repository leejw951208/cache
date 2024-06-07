package com.example.cache.groupmember;

import com.example.cache.group.domain.Group;
import com.example.cache.group.repository.GroupRepository;
import com.example.cache.groupmember.repository.GroupMemberRepository;
import com.example.cache.groupmember.service.GroupMemberService;
import com.example.cache.member.domain.Member;
import com.example.cache.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class GroupMemberServiceTest {
    @Mock
    private GroupMemberRepository groupMemberRepository;

    @Mock
    private GroupRepository groupRepository;

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private GroupMemberService groupMemberService;

    @Test
    public void save() {
        // given
        LocalDateTime createdDate = LocalDateTime.now();
        long groupId = 1L;
        List<Long> memberIds = List.of(1L, 2L, 3L);
        Group group = new Group(1L, "그룹1", createdDate);
        List<Member> members = List.of(
                new Member(1L, "유저1", 10, createdDate),
                new Member(2L, "유저2", 20, createdDate),
                new Member(3L, "유저3", 30, createdDate)
        );

        given(groupRepository.findById(groupId)).willReturn(group);
        given(memberRepository.findByIds(memberIds)).willReturn(members);
        willDoNothing().given(groupMemberRepository).save(group, members);

        // when
        groupMemberService.saveGroupMember(groupId, memberIds);

        // then
        then(groupMemberRepository).should(times(1)).save(group, members);
    }
}
