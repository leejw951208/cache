package com.example.cache.group.mapper;

import com.example.cache.group.domain.Group;
import com.example.cache.group.domain.GroupSave;
import com.example.cache.group.dto.GroupDto;
import com.example.cache.group.dto.SaveGroupDto;
import com.example.cache.group.persistence.GroupEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GroupMapper {
    GroupSave toDomain(SaveGroupDto saveGroupDto);
    Group toDomain(GroupEntity groupEntity);
    GroupEntity toEntity(GroupSave groupSave);
    GroupEntity toEntity(Group group);
    GroupDto toDto(Group group);
}
