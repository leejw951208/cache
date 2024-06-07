package com.example.cache.member.dto;

import com.example.cache.group.dto.GroupDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record MemberGroupDto(
        long id,
        String name,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime createdDate,
        GroupDto group
) {
}
