package com.example.cache.groupmember.mapper;

import com.example.cache.group.persistence.GroupEntity;
import com.example.cache.groupmember.persistence.GroupMemberEntity;
import com.example.cache.member.domain.Member;
import com.example.cache.member.persistence.MemberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GroupMemberMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    GroupMemberEntity toEntity(GroupEntity groupEntity, MemberEntity memberEntity);
    default List<GroupMemberEntity> toEntity(GroupEntity groupEntity, List<MemberEntity> memberEntities) {
        return memberEntities.stream()
                .map(memberEntity -> toEntity(groupEntity, memberEntity))
                .collect(Collectors.toList());
    }
}
