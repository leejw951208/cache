package com.example.cache.member.mapper;

import com.example.cache.group.domain.Group;
import com.example.cache.member.domain.Member;
import com.example.cache.member.domain.MemberGroup;
import com.example.cache.member.domain.MemberSave;
import com.example.cache.member.domain.MemberUpdate;
import com.example.cache.member.dto.MemberGroupDto;
import com.example.cache.member.dto.SaveMemberDto;
import com.example.cache.member.persistence.MemberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
    MemberSave toDomain(SaveMemberDto saveMemberDto);
    Member toDomain(MemberEntity memberEntity);
    List<Member> toDomain(List<MemberEntity> memberEntities);
    @Mapping(target = "id", source = "member.id")
    @Mapping(target = "name", source = "member.name")
    @Mapping(target = "age", source = "member.age")
    @Mapping(target = "createdDate", source = "member.createdDate")
    MemberGroup toDomain(Member member, Group group);
    MemberEntity toEntity(MemberSave memberSave);
    MemberEntity toEntity(MemberUpdate memberUpdate);
    List<MemberEntity> toEntity(List<Member> members);
    MemberGroupDto toDto(MemberGroup memberGroup);
}
